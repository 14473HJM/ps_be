package ar.edu.utn.frc.tup.ps.psappbe.services.project.status;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.ProfessorService;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.StudentService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.CommentService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.ProjectService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class ProjectStatusServicePropAccepted extends ProjectStatusBaseService implements ProjectStatusService {

    public ProjectStatusServicePropAccepted(@Autowired CommentService commentService,
                                       @Autowired ProfessorService professorService,
                                       @Autowired UserService userService,
                                       @Autowired StudentService studentService) {
        super(commentService, professorService, userService, studentService);
    }

    @Override
    ProjectStatus previous() {
        return ProjectStatus.UNDER_PROP_REVIEW;
    }

    @Override
    ProjectStatus current() {
        return ProjectStatus.PROP_ACCEPTED;
    }

    @Override
    ProjectStatus next() {
        return ProjectStatus.WIP;
    }

    @Override
    void validateMoveOn(Project project) {
        if(isNull(project.getIssueTracker()) ||
                isNull(project.getCodeRepositories()) || project.getCodeRepositories().isEmpty() ||
                //Todo - Volver a poner la regla cuando tengamos esto para despues del MVP
                //isNull(project.getSystemComponents()) || project.getSystemComponents().isEmpty() ||
                isNull(project.getTutor())
        ) {
            throw new IllegalArgumentException("Faltan datos necesarios para mover el proyecto a la siguiente etapa.");
        }
    }

    @Override
    void validateMoveBack(Project project) {

    }

    @Override
    void validateCancel(Project project) {

    }

    @Override
    public Project moveBack(Project project, Comment comment) {
        throw new IllegalArgumentException("Transici??n no permitida. Cuando la propuesta fue aceptada " +
                "y ya comenzo el trabajo de la misma ya no puede volver a los estados previos. " +
                "Si necesita hacer una modificaci??n, debe gestionarse con " +
                "el tutor de la PS o un Usuario administrador.");
    }
}
