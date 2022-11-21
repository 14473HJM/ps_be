package ar.edu.utn.frc.tup.ps.psappbe.entities.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.InvitationStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invitations")
public class InvitationEntity extends CommonFieldsEntity {

    @Column(unique=true)
    private String hash;
    private String legajo;
    private String email;
    private String link;

    @Enumerated(EnumType.STRING)
    private InvitationStatus invitationStatus;

    private LocalDateTime usedDate;
    private LocalDateTime dueDateTime;
}
