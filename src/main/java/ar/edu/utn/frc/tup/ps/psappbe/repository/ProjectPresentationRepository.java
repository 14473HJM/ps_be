package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectPresentationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectPresentationRepository extends JpaRepository<ProjectPresentationEntity, Long> {
}
