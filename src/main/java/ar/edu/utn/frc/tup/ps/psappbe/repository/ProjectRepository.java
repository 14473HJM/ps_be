package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.ProfessorEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    @Query("SELECT P " +
            "FROM ProjectEntity P JOIN P.students PS " +
            "WHERE PS.id = :studentId")
    List<ProjectEntity> getAllProjectsByStudentId(Long studentId);

    @Query("SELECT P " +
            "FROM ProjectEntity P " +
            "WHERE P.tutor.id = :tutorId")
    List<ProjectEntity> getAllByTutor(Long tutorId);
}
