package ar.edu.utn.frc.tup.ps.psappbe.entities.project.issue;

import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "issue_tracker_links")
public class IssueTrackerLinkEntity extends CommonFieldsEntity {
    @ManyToOne
    @JoinColumn(name = "issue_tracker_id")
    private IssueTrackerEntity issueTracker;
    private String link;
}