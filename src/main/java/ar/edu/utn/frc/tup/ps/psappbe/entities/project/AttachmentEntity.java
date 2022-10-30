package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.PersonEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attachments")
public class AttachmentEntity extends CommonFieldsEntity {
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PersonEntity owner;
    private String attachmentLink;
}