package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication.MinutesOfMeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinutesOfMeetingRepository extends JpaRepository<MinutesOfMeetingEntity, Long> {
}
