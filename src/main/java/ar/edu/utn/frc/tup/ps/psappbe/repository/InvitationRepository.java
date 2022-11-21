package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.user.InvitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationRepository extends JpaRepository<InvitationEntity, Long> {

    InvitationEntity getInvitationEntityByHash(String hash);

    List<InvitationEntity> getInvitationEntitiesByLegajo(String legajo);

    List<InvitationEntity> getInvitationEntitiesByCreatedUser(String createdUser);
}
