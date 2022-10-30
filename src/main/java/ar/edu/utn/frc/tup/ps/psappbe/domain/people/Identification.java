package ar.edu.utn.frc.tup.ps.psappbe.domain.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identification {

    private String identification;
    private IdentificationType identificationType;
}
