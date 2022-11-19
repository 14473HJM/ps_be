package ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meeting extends CommonFields {

    public static final String OBJECT_TYPE = "MEETING";

    private String topic;
    private String description;
    private LocalDateTime meetingDateTime;
    private Person requester;
    private List<Person> guests;
    private List<Person> attendances;
    private String meetingLink;
    private Boolean wasMade;
    private MinutesOfMeeting minutesOfMeeting;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
