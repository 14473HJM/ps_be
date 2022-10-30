package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.project.SystemComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemComponentRepository extends JpaRepository<SystemComponentEntity, Long> {
}
