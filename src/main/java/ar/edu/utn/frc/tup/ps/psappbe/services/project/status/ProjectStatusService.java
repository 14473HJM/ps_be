package ar.edu.utn.frc.tup.ps.psappbe.services.project.status;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;

public interface ProjectStatusService {

    Project moveOn(Project project, Comment comment);
    Project moveBack(Project project, Comment comment);
    Project cancel(Project project, Comment comment);

}
