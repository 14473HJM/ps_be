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
@Table(name = "user_interfaces")
public class UserInterfaceEntity extends CommonFieldsEntity {

    /**
     * WEB, MOBILE, DESKTOP
     */

    private String type;
    private String name;
}
