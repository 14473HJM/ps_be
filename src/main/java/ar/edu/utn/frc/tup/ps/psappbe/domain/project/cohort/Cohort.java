package ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort;


import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cohort extends CommonFields {

    public static final String OBJECT_TYPE = "COHORT";

    private Integer semester;
    private Integer year;
    private String name;
    private CohortStatus cohortStatus;
    private LocalDate proposalLimit;
    private LocalDate workLimit;
    private LocalDate presentationLimit;
    private LocalDate endDate;
    private String folder;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
