package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String userName);
}
