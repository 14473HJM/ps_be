package ar.edu.utn.frc.tup.ps.psappbe.services.project.status;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.CommentService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.ConversationService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProjectStatusServiceUnderPropReview implements ProjectStatusService {

    private final ProjectService projectService;

    @Override
    public Project doNext(Project project, Comment comment) {
        if(project.getProjectStatus() != ProjectStatus.CREATED) {
            throw new IllegalArgumentException("Transición no permitida de " + project.getProjectStatus().name()
            + " a " + ProjectStatus.UNDER_PROP_REVIEW.name());
        }
        comment = projectService.publishProjectComment(project.getId(), comment);
        project.setProjectStatus(ProjectStatus.UNDER_PROP_REVIEW);
        project = projectService.update(project);
        return project;
    }

    @Override
    public Project doPrevious(Project project, Comment comment) {
        return null;
    }

    @Override
    public Project doCancel(Project project, Comment comment) {
        return null;
    }
}
