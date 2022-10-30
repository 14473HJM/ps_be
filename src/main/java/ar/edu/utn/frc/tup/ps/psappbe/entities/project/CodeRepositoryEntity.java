package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "code_repositories")
public class CodeRepositoryEntity extends CommonFieldsEntity {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
    @ManyToOne
    @JoinColumn(name = "internet_platform_id")
    private InternetPlatformEntity internetPlatform;
    private String ownerName;
    private String repositoryLink;
    private String productionBranchName;
}