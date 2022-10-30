package ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.PersonEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
public class CommentEntity extends CommonFieldsEntity {
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private ConversationEntity conversation;

    @ManyToOne
    @JoinColumn(name = "commentator_id")
    private PersonEntity commentator;

    private String comment;
}