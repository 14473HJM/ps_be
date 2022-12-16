package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Attachment;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "project_presentations")
public class ProjectPresentationEntity extends CommonFieldsEntity {

    private String presentationVideoLink;
    private String demoVideoLink;
    private String finalDocumentLink;
    private String deliveryLink;
}