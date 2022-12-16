package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.*;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProjectService extends BaseModelService<Project, ProjectEntity> {

    Comment publishProjectComment(Long projectId, Comment comment);

    Project changeProjectStatus(Long projectId, Comment comment, ProjectStatusAction action);

    List<Project> getProjectsByUserId(Long userId, Boolean includeDeletes);

    Boolean isOwner(Project project, Student student);

    Boolean isOwner(Project project, Professor professor);

    Project changeTutor(Long projectId, Long tutorId, Comment comment);

    Project addObserver(Long projectId, Long observerId, Comment comment);

    Project deleteObserver(Long projectId, Long observerId, Comment comment);

    ProjectPresentation publishProjectPresentation(Long projectId, ProjectPresentation projectPresentation);

    List<Valuation> publishProjectValuations(Long projectId, List<Valuation> valuations);
}
