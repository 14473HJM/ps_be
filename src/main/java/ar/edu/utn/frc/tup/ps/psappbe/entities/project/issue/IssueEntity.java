package ar.edu.utn.frc.tup.ps.psappbe.entities.project.issue;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.issue.IssueStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.PersonEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication.ConversationEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "issues")
public class IssueEntity extends CommonFieldsEntity {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;
    private String summary;
    private String resume;

    @ManyToOne
    @JoinColumn(name = "informer_id")
    private PersonEntity informer;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private PersonEntity responsible;

    @OneToOne
    @JoinColumn(name = "conversation_id")
    private ConversationEntity conversation;
}