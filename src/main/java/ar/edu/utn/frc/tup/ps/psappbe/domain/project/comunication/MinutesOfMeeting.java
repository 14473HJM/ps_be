package ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinutesOfMeeting extends CommonFields {

    public static final String OBJECT_TYPE = "MINUTES_OF_MEETING";

    private String minutesOfMeeting;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
