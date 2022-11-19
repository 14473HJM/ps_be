package ar.edu.utn.frc.tup.ps.psappbe.domain.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Platform extends CommonFields {

    /**
     * LOCAL, DOCKER, AWS, GCP, AZURE
     */
    public static final String OBJECT_TYPE = "PLATFORM";

    private String type;
    private String name;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
