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
@Table(name = "code_languages")
public class CodeLanguageEntity extends CommonFieldsEntity {

    /**
     * JAVA, PHP, JS, C#
     */

    private String type;
    private String name;
}
