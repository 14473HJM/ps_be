package ar.edu.utn.frc.tup.ps.psappbe.services.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Invitation;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.InvitationEntity;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelService;

import javax.servlet.UnavailableException;
import java.util.List;

public interface InvitationService extends BaseModelService<Invitation, InvitationEntity> {

    Invitation createInvitation(String legajo, String email);

    Invitation getInvitation(String hash);

    List<Invitation> getInvitations(String createdUser);

    void sendInvitation(Invitation invitation) throws UnavailableException;

    Invitation resendInvitation(Long invitationId) throws UnavailableException;

    Invitation cancelInvitation(Long invitationId) throws UnavailableException;
}
