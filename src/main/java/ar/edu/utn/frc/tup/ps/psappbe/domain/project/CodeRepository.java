package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeRepository {

    private Long id;
    private InternetPlatform internetPlatform;
    private String ownerName;
    private String repositoryLink;
    private String productionBranchName;
}
