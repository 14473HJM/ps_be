package ar.edu.utn.frc.tup.ps.psappbe.domain.project.issue;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue extends CommonFields {

    public static final String OBJECT_TYPE = "ISSUE";

    private LocalDate dueDate;
    private IssueStatus issueStatus;
    private String summary;
    private String resume;
    private Person informer;
    private Person responsible;
    private Conversation conversation;


    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
