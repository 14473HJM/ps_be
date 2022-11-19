package ar.edu.utn.frc.tup.ps.psappbe.domain.address;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends CommonFields {

    public static final String OBJECT_TYPE = "ADDRESS";

    private String street;
    private String streetNumber;
    private String zipCode;
    private String detail;
    private String city;
    private Province province;
    private Country country;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
