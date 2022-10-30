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
@Table(name = "technologies")
public class TechnologyEntity extends CommonFieldsEntity {

    /**
     * BACK END, FRONT END, DATA BASE, QUEUES
     */

    private String type;
    private String name;
}
