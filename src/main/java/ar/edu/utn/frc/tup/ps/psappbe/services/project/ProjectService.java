package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelService;

import java.util.List;

public interface ProjectService extends BaseModelService<Project, ProjectEntity> {

    Comment publishProjectComment(Long projectId, Comment comment);

    Project changeProjectStatus(Project project, ProjectStatus projectStatus);

    List<Project> getProjectsByUserId(Long userId);
}
