package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeRepository extends CommonFields {

    public static final String OBJECT_TYPE = "CODE_REPOSITORY";

    private Long projectId;
    private InternetPlatform internetPlatform;
    private String ownerName;
    private String repositoryLink;
    private String productionBranchName;


    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
