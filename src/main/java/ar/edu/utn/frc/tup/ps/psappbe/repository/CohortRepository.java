package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.CohortStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.cohort.CohortEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CohortRepository extends JpaRepository<CohortEntity, Long> {

    List<CohortEntity> getAllByCohortStatus(CohortStatus cohortStatus);
}
