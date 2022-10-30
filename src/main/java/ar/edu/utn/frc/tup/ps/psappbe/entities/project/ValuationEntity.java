package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ValuationType;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.ProfessorEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "valuations")
public class ValuationEntity extends CommonFieldsEntity {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @Enumerated(EnumType.STRING)
    private ValuationType valuationType;
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "evaluator_id")
    private ProfessorEntity evaluator;
    private String resume;

}