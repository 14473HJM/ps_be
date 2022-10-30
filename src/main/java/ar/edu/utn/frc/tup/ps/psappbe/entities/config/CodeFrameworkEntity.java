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
@Table(name = "code_frameworks")
public class CodeFrameworkEntity extends CommonFieldsEntity {

    /**
     * SPRING BOOT, REACT, ANGULAR, REACT NATIVE
     */
    private String name;
    private String type;
    private String description;
    private String imageLink;
    private String iconLink;
}
