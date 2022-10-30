package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeLanguageRepository extends JpaRepository<CodeLanguageEntity, Long> {
}
