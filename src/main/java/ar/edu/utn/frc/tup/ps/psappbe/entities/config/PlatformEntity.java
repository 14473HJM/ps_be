package ar.edu.utn.frc.tup.ps.psappbe.entities.config;

import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "platforms")
public class PlatformEntity extends CommonFieldsEntity {

    /**
     * LOCAL, DOCKER, AWS, GCP, AZURE
     */

    private String type;
    private String name;

}
