package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.AcademicStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Contact;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Grade;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Identification;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class StudentEntity extends PersonEntity {

    @OneToOne
    @JoinColumn(name = "university_identification_id")
    private IdentificationEntity universityIdentification;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @Fetch(FetchMode.SELECT)
    private List<ContactEntity> universityContacts;

    private BigDecimal careerAverage;
    private LocalDate careerRegistrationDate;
    private String imageProfile;
    @Enumerated(EnumType.STRING)
    private AcademicStatus academicStatus;

    @OneToOne
    @JoinColumn(name = "grade_id")
    private GradeEntity gradeEntity;
}