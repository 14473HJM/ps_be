package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "internet_platforms")
public class InternetPlatformEntity extends CommonFieldsEntity {

    private String baseUrl;
    private String icon;
    private Boolean isSocialNetwork;
    private Boolean isGitPlatform;
}