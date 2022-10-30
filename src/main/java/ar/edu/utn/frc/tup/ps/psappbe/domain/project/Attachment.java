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

    private Project project;
    private Person owner;
    private String attachmentLink;
}
