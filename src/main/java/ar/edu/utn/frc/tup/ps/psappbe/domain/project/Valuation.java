package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Valuation extends CommonFields {

    public static final String OBJECT_TYPE = "VALUATION";

    private Long id;
    private ValuationType valuationType;
    private BigDecimal value;
    private Professor evaluator;
    private String resume;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
