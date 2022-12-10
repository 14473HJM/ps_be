package ar.edu.utn.frc.tup.ps.psappbe.domain.project.issue;


import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueTrackerLink extends CommonFields {

    public static final String OBJECT_TYPE = "ISSUE_TRACKER_LINK";

    private Long issueTrackerId;
    private String link;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
