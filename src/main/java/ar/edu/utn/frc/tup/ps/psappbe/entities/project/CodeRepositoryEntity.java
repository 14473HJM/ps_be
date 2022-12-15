package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "code_repositories")
public class CodeRepositoryEntity extends CommonFieldsEntity {

    @JoinColumn(name = "project_id")
    private Long projectId;
    @ManyToOne
    @JoinColumn(name = "internet_platform_id")
    private InternetPlatformEntity internetPlatform;
    private String ownerName;
    private String repositoryLink;
    private String productionBranchName;
}