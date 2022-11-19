package ar.edu.utn.frc.tup.ps.psappbe.domain.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identification extends CommonFields {

    public static final String OBJECT_TYPE = "IDENTIFICATION";

    private String identification;
    private IdentificationType identificationType;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
