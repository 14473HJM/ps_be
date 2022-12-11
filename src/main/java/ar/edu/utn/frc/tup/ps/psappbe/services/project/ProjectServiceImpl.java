package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectScope;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatusAction;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.Cohort;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Role;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import ar.edu.utn.frc.tup.ps.psappbe.services.files.FileService;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.ProfessorService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.status.ProjectStatusFactoryService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.status.ProjectStatusService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.UnavailableException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProjectServiceImpl extends BaseModelServiceImpl<Project, ProjectEntity> implements ProjectService {

    private static final String INITIAL_PROJECT_COMMENT = "Bienvenido a la plataforma de gestión de Practicas Supervisadas de " +
            "la Tecnicatura Universitaria en Programación.\nEsta conversación puede ser leida por cualquier persona con acceso al proyecto, " +
            "incluidos profesores y alumnos.";

    private static final String TUTOR_ADDED_TO_PROJECT = "Un tutor fue asignado a su proyecto.\nPor favor " +
            "ponte en contacto con él apenas puedas para empezar a trabajar en tu PS.";

    private static final String CHANGE_TUTOR_PROJECT = "El tutor de tu proyecto ha sido modificado.\nPor favor " +
            "ponte en contacto con él apenas puedas para seguir trabajando en tu PS.";
    private final ProjectRepository projectRepository;

    private final UserService userService;

    private final ConversationService conversationService;

    private final CommentService commentService;

    private final ProjectScopeService projectScopeService;

    private final ProjectStatusFactoryService projectStatusFactoryService;

    private final CohortService cohortService;

    private final FileService fileService;

    private final ProfessorService professorService;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return projectRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public Project create(Project project) {
        // Set status in CREATED
        project.setProjectStatus(ProjectStatus.CREATED);
        // Create project conversation
        this.createProjectConversation(project);
        // Set Project Cohort
        Cohort cohort = cohortService.getActiveCohort();
        if(cohort == null) {
            throw new NoSuchElementException("No hay un Cohorte activo. Contactar con el Administrador de la plataforma.");
        }
        project.setCohort(cohort);
        // Create the project
        project = super.create(project);
        // Create tha project scopes
        this.createProjectScopes(project);
        // Create the project folder
        String projectFolder = this.createProjectFolder(cohort.getFolder(), project.getId());
        project.setProjectFolder(projectFolder);
        project = update(project);
        project = getById(project.getId());
        return project;
    }

    @Override
    public Comment publishProjectComment(Long projectId, Comment comment) {
        Project project = getById(projectId);
        Conversation conversation = project.getConversation();
        comment.setConversationId(conversation.getId());
        comment = commentService.create(comment);
        return commentService.getById(comment.getId());
    }

    @Override
    public Project changeProjectStatus(Long projectId, Comment comment, ProjectStatusAction action) {
        Project initialProject = getById(projectId);
        Project finalProject;
        ProjectStatusService projectStatusService = projectStatusFactoryService.getProjectStatusService(initialProject);
        switch (action) {
            case MOVE_ON:
                finalProject = projectStatusService.moveOn(initialProject, comment);
                break;
            case MOVE_BACK:
                finalProject = projectStatusService.moveBack(initialProject, comment);
                break;
            case CANCEL:
                finalProject = projectStatusService.cancel(initialProject, comment);
                break;
            default:
                throw new IllegalArgumentException("La acción requida no es correcta.");
        }
        return finalProject;
    }

    @Override
    public List<Project> getProjectsByUserId(Long userId) {
        User user = userService.getById(userId);
        List<ProjectEntity> projectEntities = projectRepository.getAllProjectsByStudentId(user.getPerson().getId());
        return mapList(projectEntities);
    }

    @Override
    public List<Project> getAll() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if(userName == "anonymousUser") {
            return null;
        }
        User user = userService.getByUserName(userName);
        if(user.getRoles().contains(Role.ADMIN)) {
            return super.getAll();
        } else if(user.getRoles().contains(Role.PROFESSOR)) {
            List<ProjectEntity> projectEntities = projectRepository.getAllByTutor(user.getPerson().getId());
            return mapList(projectEntities);
        } else {
            return this.getProjectsByUserId(user.getId());
        }
    }

    @Override
    public Boolean isOwner(Project project, Student student) {
        return project.getStudents().stream().anyMatch(
                (s) -> s.getId() == student.getId()
        );
    }

    @Override
    public Boolean isOwner(Project project, Professor professor) {
        return project.getTutor().getId() == project.getId();
    }

    private void createProjectScopes(Project project) {
        Long projectId = project.getId();
        project.getScopes().forEach((projectScope) ->
            projectScope.setProjectId(projectId));
        projectScopeService.createAll(project.getScopes());
    }

    private void createProjectConversation(Project project) {
        Conversation conversation = new Conversation();
        conversation.setTopic("Conversación del proyecto " + project.getName());
        conversation = conversationService.create(conversation);
        Comment initialComment = new Comment(conversation.getId(), userService.getByUserName("000000").getPerson(), INITIAL_PROJECT_COMMENT);
        initialComment = commentService.create(initialComment);
        conversation.setComments(Arrays.asList(initialComment));
        project.setConversation(conversation);
    }

    public Project changeTutor(Long projectId, Long tutorId, Comment comment) {
        Project project = getById(projectId);
        if(comment != null) {
            comment = commentService.create(comment);
            project.getConversation().getComments().add(comment);
        }
        if(project.getTutor() == null) {
            Comment autComment = new Comment(project.getConversation().getId(), userService.getByUserName("000000").getPerson(), TUTOR_ADDED_TO_PROJECT);
            autComment = commentService.create(autComment);
            project.getConversation().getComments().add(autComment);
        } else {
            Comment autComment = new Comment(project.getConversation().getId(), userService.getByUserName("000000").getPerson(), CHANGE_TUTOR_PROJECT);
            autComment = commentService.create(autComment);
            project.getConversation().getComments().add(autComment);
        }
        Professor professor = professorService.getById(tutorId);
        project.setTutor(professor);
        update(project);
        return project;
    }

    public Project addObserver(Long projectId, Long observerId, Comment comment) {
        Project project = getById(projectId);
        Professor professor = professorService.getById(observerId);
        if(!project.getObservers().stream().anyMatch(p -> p.getId() == observerId)) {
            project.getObservers().add(professor);
            update(project);
        }
        return project;
    }

    public Project deleteObserver(Long projectId, Long observerId, Comment comment) {
        Project project = getById(projectId);
        Professor professor = professorService.getById(observerId);
        // TODO Revisar si funciona
        if(!project.getObservers().stream().anyMatch(p -> p.getId() == observerId)) {
            project.getObservers().remove(professor);
            update(project);
        }
        return project;
    }

    private String createProjectFolder(String cohortFolder, Long projectId) {
        String projectFolder = null;
        try {
            projectFolder = fileService.createFolder(projectId.toString(), Arrays.asList(cohortFolder));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return projectFolder;
    }
}
