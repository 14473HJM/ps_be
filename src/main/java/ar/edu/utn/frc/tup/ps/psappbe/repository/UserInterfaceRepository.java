package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.config.UserInterfaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterfaceRepository extends JpaRepository<UserInterfaceEntity, Long> {
}
