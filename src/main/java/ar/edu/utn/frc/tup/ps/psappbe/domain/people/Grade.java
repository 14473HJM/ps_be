package ar.edu.utn.frc.tup.ps.psappbe.domain.people;


import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade extends CommonFields {

    public static final String OBJECT_TYPE = "GRADE";

    private Long id;
    private String turn;
    private String number;
    private String name;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
