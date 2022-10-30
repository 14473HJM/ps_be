package ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication;

import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "minutes_of_meetings")
public class MinutesOfMeetingEntity extends CommonFieldsEntity {

    @Column(columnDefinition="TEXT")
    private String minutesOfMeeting;
}