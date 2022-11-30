package ar.edu.utn.frc.tup.ps.psappbe.domain.people;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("student")
public class Student extends Person {

    public static final String OBJECT_TYPE = "STUDENT";

    private Identification universityIdentification;
    private List<Contact> universityContacts;
    private BigDecimal careerAverage;
    private LocalDate careerRegistrationDate;
    private AcademicStatus academicStatus;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
