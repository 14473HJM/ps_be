package ar.edu.utn.frc.tup.ps.psappbe.entities.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.*;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.Cohort;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.ProfessorEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.StudentEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.cohort.CohortEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication.ConversationEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication.MeetingEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.issue.IssueEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.issue.IssueTrackerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class ProjectEntity extends CommonFieldsEntity {

    private String name;
    private String description;
    @Column(columnDefinition="TEXT")
    private String objective;
    @Column(columnDefinition="TEXT")
    private String projectLimit;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "projectId")
    @Fetch(FetchMode.SELECT)
    private List<ProjectScopeEntity> scopes;

    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @OneToOne
    @JoinColumn(name = "cohort_id")
    private CohortEntity cohort;
    private LocalDate endDate;
    private String projectTheme;
    private Boolean isRealProject;
    private String imageLink;

    @OneToOne
    @JoinColumn(name = "issue_tracker_id")
    private IssueTrackerEntity issueTracker;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "projectId")
    @Fetch(FetchMode.SELECT)
    private List<CodeRepositoryEntity> codeRepositories;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    @Fetch(FetchMode.SELECT)
    private List<SystemComponentEntity> systemComponents;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "project_students",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> students;
    @ManyToOne
    @JoinColumn(name = "tutor_id")
    @Fetch(FetchMode.SELECT)
    private ProfessorEntity tutor;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "project_observers",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "observer_id"))
    private List<ProfessorEntity> observers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    @Fetch(FetchMode.SELECT)
    private List<ValuationEntity> valuationsEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    @Fetch(FetchMode.SELECT)
    private List<MeetingEntity> meetingsEntity;

    @OneToOne
    @JoinColumn(name = "conversationId", referencedColumnName = "id")
    private ConversationEntity conversation;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    @Fetch(FetchMode.SELECT)
    private List<IssueEntity> issuesEntity;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    @Fetch(FetchMode.SELECT)
    private List<AttachmentEntity> attachments;

    @OneToOne
    @JoinColumn(name = "project_presentation_id")
    private ProjectPresentationEntity projectPresentation;

    private String projectFolder;
}
