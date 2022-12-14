package ar.edu.utn.frc.tup.ps.psappbe.domain.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology extends CommonFields {

    /**
     * BACK END, FRONT END, DATA BASE, QUEUES
     */
    public static final String OBJECT_TYPE = "TECHNOLOGY";

    private String type;
    private String name;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
