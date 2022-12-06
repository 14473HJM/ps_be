package ar.edu.utn.frc.tup.ps.psappbe.domain.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact extends CommonFields {

    public static final String OBJECT_TYPE = "CONTACT";

    @JsonBackReference
    private Person person;
    private ContactType contactType;
    private ContactScope contactScope;
    private String value;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
