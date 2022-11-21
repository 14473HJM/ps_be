package ar.edu.utn.frc.tup.ps.psappbe.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitationRequest {

    private String legajo;
    private String email;
}
