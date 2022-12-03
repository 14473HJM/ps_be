package ar.edu.utn.frc.tup.ps.psappbe.domain.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invitation extends CommonFields {

    public static final String OBJECT_TYPE = "INVITATION";

    private String legajo;
    private String email;
    private String hash;
    private String link;
    private InvitationStatus invitationStatus;
    private LocalDateTime usedDate;
    private LocalDateTime dueDateTime;
    private Integer numberOfDeliveries;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
