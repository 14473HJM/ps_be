package ar.edu.utn.frc.tup.ps.psappbe.entities.project.cohort;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.CohortStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cohorts")
public class CohortEntity extends CommonFieldsEntity {

    private Integer quarter;
    private Integer year;
    private String name;

    @Enumerated(EnumType.STRING)
    private CohortStatus cohortStatus;
}
