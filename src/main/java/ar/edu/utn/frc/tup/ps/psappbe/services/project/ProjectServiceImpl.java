package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectScope;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatusAction;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.status.ProjectStatusFactoryService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.status.ProjectStatusService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProjectServiceImpl extends BaseModelServiceImpl<Project, ProjectEntity> implements ProjectService {

    private static final String INITIAL_PROJECT_COMMENT = "Bienvenido a la plataforma de gestión de Practicas Supervisadas de " +
            "la Tecnicatura Universitaria en Programación.\nEsta conversación puede ser leida por cualquier persona con acceso al proyecto, " +
            "incluidos profesores y alumnos.";
    private final ProjectRepository projectRepository;

    private final UserService userService;

    private final ConversationService conversationService;

    private final CommentService commentService;

    private final ProjectScopeService projectScopeService;

    private final ProjectStatusFactoryService projectStatusFactoryService;

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
        // Create the project
        project = super.create(project);
        // Create tha project scopes
        this.createProjectScopes(project);
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
        Comment initialComment = new Comment(conversation.getId(), null, INITIAL_PROJECT_COMMENT);
        initialComment = commentService.create(initialComment);
        conversation.setComments(Arrays.asList(initialComment));
        project.setConversation(conversation);
    }
}
