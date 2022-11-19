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

    public static final String OBJECT_TYPE = "PROJECT";

    private String name; //MVP
    private String description; //MVP
    private ProjectType projectType; //MVP
    private ProjectStatus projectStatus; //MVP
    private LocalDate endDate; //MVP
    private String projectTheme; //MVP
    private Boolean isRealProject; //MVP
    private String imageLink; //MVP

    private IssueTracker issueTracker; //MVP
    private List<CodeRepository> codeRepositories; //MVP
    private List<SystemComponent> systemComponents; //MVP

    private Student student; //MVP
    private Professor tutor; //MVP
    private List<Professor> observers; //NO MVP
    private List<Valuation> valuations; //MVP
    private AcademicCondition academicCondition; //MVP

    private List<Meeting> meetings; //NO MVP
    private Conversation conversation; //MVP
    private List<Issue> issues; //NO MVP

    private List<Attachment> attachments; //MVP
    private ProjectPresentation projectPresentation; //MVP


    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
