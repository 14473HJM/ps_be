package ar.edu.utn.frc.tup.ps.psappbe.domain.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeFramework extends CommonFields {

    public static final String OBJECT_TYPE = "CODE_FRAMEWORK";

    /**
     * SPRING BOOT, REACT, ANGULAR, REACT NATIVE
     */
    private String name;
    private String type;
    private String description;
    private String imageLink;
    private String iconLink;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
