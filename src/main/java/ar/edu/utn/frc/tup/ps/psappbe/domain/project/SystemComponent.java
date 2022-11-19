package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeFrameworkEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeLanguageEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.PlatformEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.TechnologyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemComponent extends CommonFields {

    public static final String OBJECT_TYPE = "SYSTEM_COMPONENT";

    private String name;
    private String description;
    private PlatformEntity platformEntity;
    private TechnologyEntity technologyEntity;
    private CodeLanguageEntity codeLanguageEntity;
    private CodeFrameworkEntity codeFrameworkEntity;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
