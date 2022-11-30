package ar.edu.utn.frc.tup.ps.psappbe.services.project.status;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;

public interface ProjectStatusService {

    Project doNext(Project project, Comment comment);
    Project doPrevious(Project project, Comment comment);
    Project doCancel(Project project, Comment comment);

}
