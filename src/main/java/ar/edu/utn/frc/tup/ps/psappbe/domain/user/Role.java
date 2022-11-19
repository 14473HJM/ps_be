package ar.edu.utn.frc.tup.ps.psappbe.domain.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends CommonFields {

    public static final String OBJECT_TYPE = "ROLE";

    private String name;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
