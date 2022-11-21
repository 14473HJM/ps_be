package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.*;
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
@DiscriminatorValue(Student.OBJECT_TYPE)
public class StudentEntity extends PersonEntity {

    private BigDecimal careerAverage;
    private LocalDate careerRegistrationDate;

    @Enumerated(EnumType.STRING)
    private AcademicStatus academicStatus;

    @OneToOne
    @JoinColumn(name = "grade_id")
    private GradeEntity gradeE;
}