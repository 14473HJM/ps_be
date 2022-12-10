package ar.edu.utn.frc.tup.ps.psappbe.entities.project.cohort;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.CohortStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cohorts")
public class CohortEntity extends CommonFieldsEntity {

    private Integer semester;
    private Integer year;
    private String name;

    @Enumerated(EnumType.STRING)
    private CohortStatus cohortStatus;

    private LocalDate proposalLimit;
    private LocalDate workLimit;
    private LocalDate presentationLimit;
    private LocalDate endDate;
    private String folder;
}
