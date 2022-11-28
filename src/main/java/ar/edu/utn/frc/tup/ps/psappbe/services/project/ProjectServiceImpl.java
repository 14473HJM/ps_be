package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProjectServiceImpl extends BaseModelServiceImpl<Project, ProjectEntity> implements ProjectService {

    private static final String INITIAL_PROJECT_COMMENT = "Bienvenido a la plataforma de gestión de Practicas Supervisadas de " +
            "la Tecnicatura Universitaria en Programación.\nEsta conversación puede ser leida por cualquier persona con acceso al proyecto, " +
            "incluidos profesores y alumnos.";
    private final ProjectRepository projectRepository;

    private final ConversationService conversationService;

    private final CommentService commentService;

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
        project.setProjectStatus(ProjectStatus.CREATED);
        this.createProjectConversation(project);


        project = super.create(project);
        return project;
    }

    private void createProjectConversation(Project project) {
        Conversation conversation = new Conversation();
        conversation.setTopic("Conversación del proyecto " + project.getName());
        conversation = conversationService.create(conversation);
        Comment initialComment = new Comment(conversation, null, INITIAL_PROJECT_COMMENT);
        initialComment = commentService.create(initialComment);
        conversation.setComments(Arrays.asList(initialComment));
        project.setConversation(conversation);
    }
}
