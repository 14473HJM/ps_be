package ar.edu.utn.frc.tup.ps.psappbe.entities.project.issue;

import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.InternetPlatformEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "issue_trackers")
public class IssueTrackerEntity extends CommonFieldsEntity {

    @ManyToOne
    @JoinColumn(name = "internet_platform_id")
    private InternetPlatformEntity internetPlatform;
    private String ownerName;
    private String projectName;
    private String projectLink;

}