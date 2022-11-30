package ar.edu.utn.frc.tup.ps.psappbe.domain.project;


import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.Cohort;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Meeting;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.issue.Issue;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.issue.IssueTracker;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project extends CommonFields {

    @JsonIgnore
    public static final String OBJECT_TYPE = "PROJECT";

    @NotBlank(message = "El nombre del proyecto debe tener al menos 1 caracter distinto de espacios en blanco.")
    @Size(min = 3, max = 100, message = "El tema del proyecto debe tener entre 10 y 100 caracteres.")
    private String name; //MVP

    @NotBlank(message = "La descripción del proyecto debe tener al menos 1 caracter distinto de espacios en blanco.")
    @Size(min = 10, max = 250, message = "La descripción del proyecto debe tener entre 10 y 250 caracteres.")
    private String description; //MVP

    @NotBlank(message = "El objetivo del proyecto debe tener al menos 1 caracter distinto de espacios en blanco.")
    private String objective;

    @NotBlank(message = "El limite del proyecto debe tener al menos 1 caracter distinto de espacios en blanco.")
    private String projectLimit;

    @Valid
    @NotEmpty(message = "La lista de alcances no puede estar vacia.")
    private List<@Valid ProjectScope> scopes;

    @NotNull(message = "El tipo de proyecto es un campo requerido.")
    private ProjectType projectType; //MVP
    private ProjectStatus projectStatus; //MVP
    private Cohort cohort;
    private LocalDate endDate; //MVP

    @Size(min = 10, max = 100, message = "El tema del proyecto debe tener entre 10 y 100 caracteres.")
    private String projectTheme; //MVP

    private Boolean isRealProject; //MVP
    private String imageLink; //MVP

    private IssueTracker issueTracker; //MVP
    private List<CodeRepository> codeRepositories; //MVP
    private List<SystemComponent> systemComponents; //MVP

    @NotEmpty(message = "La lista de estudiantes a cargo del proyecto no puede estar vacia.")
    private List<Student> students; //MVP
    private Professor tutor; //MVP
    private List<Professor> observers; //NO MVP
    private List<Valuation> valuations; //MVP

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
