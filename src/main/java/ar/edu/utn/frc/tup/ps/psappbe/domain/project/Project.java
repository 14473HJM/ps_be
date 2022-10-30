package ar.edu.utn.frc.tup.ps.psappbe.domain.project;


import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Meeting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project extends CommonFields {

    private String name;
    private String description;
    private ProjectType projectType;
    private ProjectStatus projectStatus;
    private LocalDate endDate;
    private String projectTheme;
    private Boolean isRealProject;
    private String imageLink;

    private IssueTracker issueTracker;
    private List<CodeRepository> codeRepositories;
    private List<SystemComponent> systemComponents;

    private Student student;
    private Professor tutor;
    private List<Professor> observers;
    private List<Valuation> valuations;
    private AcademicCondition academicCondition;

    private List<Meeting> meetings;
    private Conversation conversation;
    private List<Issue> issues;

    private List<Attachment> attachments;
    private ProjectPresentation projectPresentation;


}
