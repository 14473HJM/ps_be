package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeFrameworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeFrameworkRepository extends JpaRepository<CodeFrameworkEntity, Long> {
}
