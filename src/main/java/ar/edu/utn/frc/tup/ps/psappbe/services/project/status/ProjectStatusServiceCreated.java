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
import javax.validation.Valid;


@Service
@Transactional
@Slf4j
public class ProjectStatusServiceCreated extends ProjectStatusBaseService implements ProjectStatusService {

    public ProjectStatusServiceCreated(@Autowired CommentService commentService,
                                               @Autowired ProfessorService professorService,
                                               @Autowired UserService userService,
                                               @Autowired StudentService studentService) {
        super(commentService, professorService, userService, studentService);
    }

    @Override
    ProjectStatus previous() {
        return null;
    }

    @Override
    ProjectStatus current() {
        return ProjectStatus.CREATED;
    }

    @Override
    ProjectStatus next() {
        return ProjectStatus.UNDER_PROP_REVIEW;
    }

    @Override
    void validateMoveOn(Project project) {
        if(isNull(project.getName()) ||
                isNull(project.getDescription()) ||
                isNull(project.getObjective()) ||
                isNull(project.getProjectLimit()) ||
                isNull(project.getScopes()) || project.getScopes().isEmpty() ||
                isNull(project.getProjectType()) ||
                isNull(project.getCohort()) ||
                isNull(project.getIsRealProject()) ||
                isNull(project.getStudents()) || project.getStudents().isEmpty() ||
                isNull(project.getProjectTheme())
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
        throw new IllegalArgumentException("Transición no permitida desde " + project.getProjectStatus().name()
                    + ". No existe un estado previo.");
    }
}
