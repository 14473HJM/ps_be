package ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort;


import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cohort extends CommonFields {

    public static final String OBJECT_TYPE = "COHORT";

    private Integer quarter;
    private Integer year;
    private String name;
    private CohortStatus cohortStatus;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
