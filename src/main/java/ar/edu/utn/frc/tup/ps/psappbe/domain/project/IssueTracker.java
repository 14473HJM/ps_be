package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueTracker {

    private Long id;
    private InternetPlatform internetPlatform;
    private String ownerName;
    private String projectName;
    private List<String> boardLinks;
    private List<String> dashboardLinks;
}
