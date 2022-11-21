package ar.edu.utn.frc.tup.ps.psappbe.services.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Invitation;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.InvitationStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.InvitationEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.InvitationRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InvitationServiceImpl extends BaseModelServiceImpl<Invitation, InvitationEntity> implements InvitationService{

    private final InvitationRepository invitationRepository;

    private final ModelMapper modelMapper;

    @Value("app.front.url")
    private String frontUrl;

    private static final String FRONT_INVITATION_URL = "/invitation?";
    private static final String FRONT_INVITATION_QUERY_PARAM = "hash=";

    @Override
    protected JpaRepository getJpaRepository() {
        return invitationRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public Invitation sendInvitation(String legajo, String email) {
        List<Invitation> invitationList = this.getInvitationEntitiesByLegajo(legajo);
        // if invitation not exist
        if(invitationList.isEmpty()) {
            return createInvitation(legajo, email);
        } else {
            // if exist at least one invitation
            for(Invitation invitation : invitationList) {
                if(invitation.getInvitationStatus() == InvitationStatus.ACTIVE
                && invitation.getDueDateTime().isAfter(LocalDateTime.now())) {
                    return invitation;
                }
                if(invitation.getInvitationStatus() == InvitationStatus.ACTIVE
                        && invitation.getDueDateTime().isBefore(LocalDateTime.now())) {
                    invitation.setInvitationStatus(InvitationStatus.OVERDUE);
                    this.update(invitation);
                }
            }
            // if not ACTIVE invitation
            return createInvitation(legajo, email);
        }
    }

    @Override
    public Invitation getInvitation(String hash) {
        InvitationEntity entity = invitationRepository.getInvitationEntityByHash(hash);
        if(entity != null) {
            return map(entity);
        } else {
            throw new EntityNotFoundException("No se encontró la invitación requerida");
        }
    }

    @Override
    public List<Invitation> getInvitations(String createdUser) {
        List<InvitationEntity> invitationEntityList = invitationRepository.getInvitationEntitiesByCreatedUser(createdUser);
        if (invitationEntityList.isEmpty()) {
            throw new EntityNotFoundException("No hay invitaciones creadas por el usuario " + createdUser);
        } else {
            return mapList(invitationEntityList);
        }
    }

    private List<Invitation> getInvitationEntitiesByLegajo(String legajo) {
        List<InvitationEntity> invitationEntityList = invitationRepository.getInvitationEntitiesByLegajo(legajo);
        return mapList(invitationEntityList);
    }

    private Invitation createInvitation(String legajo, String email) {
        Invitation invitation = new Invitation();
        invitation.setHash(this.getHash());
        invitation.setLegajo(legajo);
        invitation.setInvitationStatus(InvitationStatus.ACTIVE);
        invitation.setDueDateTime(this.getHashDueDateTime());
        invitation.setEmail(email);
        invitation.setLink(getLink(invitation.getHash()));
        invitation = this.create(invitation);
        return invitation;
    }

    private String getHash() {
        return UUID.randomUUID().toString();
    }

    private LocalDateTime getHashDueDateTime() {
        return LocalDateTime.now().plusDays(15);
    }

    private String getLink(String hash) {
        return frontUrl + FRONT_INVITATION_URL + FRONT_INVITATION_QUERY_PARAM + hash;
    }
}
