package ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "conversations")
public class ConversationEntity extends CommonFieldsEntity {

    private String topic;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "conversation")
    @Fetch(FetchMode.SELECT)
    private List<CommentEntity> comments;

}