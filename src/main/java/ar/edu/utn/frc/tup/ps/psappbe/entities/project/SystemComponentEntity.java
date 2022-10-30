package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeFrameworkEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.CodeLanguageEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.PlatformEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.config.TechnologyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_components")
public class SystemComponentEntity extends CommonFieldsEntity {

    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @OneToOne
    @JoinColumn(name = "platform_d")
    private PlatformEntity platformEntity;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private TechnologyEntity technologyEntity;

    @ManyToOne
    @JoinColumn(name = "code_language_id")
    private CodeLanguageEntity codeLanguageEntity;

    @ManyToOne
    @JoinColumn(name = "code_framework_id")
    private CodeFrameworkEntity codeFrameworkEntity;

}
