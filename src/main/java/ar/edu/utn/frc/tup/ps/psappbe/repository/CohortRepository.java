package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.project.cohort.CohortEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CohortRepository extends JpaRepository<CohortEntity, Long> {
}
