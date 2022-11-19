package ar.edu.utn.frc.tup.ps.psappbe.domain.config;


import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeLanguage extends CommonFields {

    /**
     * JAVA, PHP, JS, C#
     */
    public static final String OBJECT_TYPE = "CODE_LANGUAGE";

    private String type;
    private String name;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
