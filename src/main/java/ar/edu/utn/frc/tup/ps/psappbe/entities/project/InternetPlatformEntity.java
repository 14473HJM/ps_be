package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatformType;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "internet_platforms")
public class InternetPlatformEntity extends CommonFieldsEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private InternetPlatformType type;
    private String baseUrl;
    private String linkImageLogo;
}