package ar.edu.utn.frc.tup.ps.psappbe.domain.project.issue;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueTracker extends CommonFields {

    public static final String OBJECT_TYPE = "ISSUE_TRACKER";

    private Long id;
    private InternetPlatform internetPlatform;
    private String ownerName;
    private String projectLink;
    private String projectName;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
