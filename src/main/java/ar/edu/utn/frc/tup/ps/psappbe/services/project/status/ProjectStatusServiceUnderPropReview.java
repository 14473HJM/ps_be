package ar.edu.utn.frc.tup.ps.psappbe.services.project.status;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
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
public class ProjectStatusServiceUnderPropReview extends ProjectStatusBaseService implements ProjectStatusService {

    public ProjectStatusServiceUnderPropReview(@Autowired CommentService commentService,
                                   @Autowired ProfessorService professorService,
                                   @Autowired UserService userService,
                                   @Autowired StudentService studentService) {
        super(commentService, professorService, userService, studentService);
    }

    @Override
    ProjectStatus previous() {
        return ProjectStatus.CREATED;
    }

    @Override
    ProjectStatus current() {
        return ProjectStatus.UNDER_PROP_REVIEW;
    }

    @Override
    ProjectStatus next() {
        return ProjectStatus.PROP_ACCEPTED;
    }

    @Override
    void validateMoveOn(Project project) {

    }

    @Override
    void validateMoveBack(Project project) {

    }

    @Override
    void validateCancel(Project project) {

    }
}
