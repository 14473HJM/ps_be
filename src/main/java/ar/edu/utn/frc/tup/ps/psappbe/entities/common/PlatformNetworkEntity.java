package ar.edu.utn.frc.tup.ps.psappbe.entities.common;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.PersonEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.InternetPlatformEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "platform_networks")
public class PlatformNetworkEntity extends CommonFieldsEntity{
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "internet_platform_id")
    private InternetPlatformEntity internetPlatform;
    private String profileName;

}