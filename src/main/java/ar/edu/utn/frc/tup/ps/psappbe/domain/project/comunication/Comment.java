package ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends CommonFields {

    public static final String OBJECT_TYPE = "COMMENT";
    private Conversation conversation;
    private Person commentator;
    private String comment;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
