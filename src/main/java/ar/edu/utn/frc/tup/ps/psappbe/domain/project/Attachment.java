package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends CommonFields {

    public static final String OBJECT_TYPE = "ATTACHMENT";

    private Project project;
    private Person owner;
    private String attachmentLink;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
