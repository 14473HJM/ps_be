package ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.MinutesOfMeeting;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.PersonEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "meetings")
public class MeetingEntity extends CommonFieldsEntity {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
    private String topic;
    private String description;
    private LocalDateTime meetingDateTime;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private PersonEntity requester;

    @ManyToMany
    @JoinTable(
            name = "meet_guests",
            joinColumns = @JoinColumn(name = "meet_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id"))
    private List<PersonEntity> guests;

    @ManyToMany
    @JoinTable(
            name = "meet_attendances",
            joinColumns = @JoinColumn(name = "meet_id"),
            inverseJoinColumns = @JoinColumn(name = "attendance_id"))
    private List<PersonEntity> attendances;

    private String meetingLink;
    private Boolean wasMade;

    @OneToOne
    @JoinColumn(name = "minutes_of_meeting_id")
    private MinutesOfMeetingEntity minutesOfMeeting;
}