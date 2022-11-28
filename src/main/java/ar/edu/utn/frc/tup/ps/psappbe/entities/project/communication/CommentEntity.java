package ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.PersonEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
public class CommentEntity extends CommonFieldsEntity {

    @JoinColumn(name = "conversation_id")
    private Long conversationId;

    @ManyToOne
    @JoinColumn(name = "commentator_id")
    private PersonEntity commentator;

    @Column(columnDefinition="TEXT")
    private String comment;
}