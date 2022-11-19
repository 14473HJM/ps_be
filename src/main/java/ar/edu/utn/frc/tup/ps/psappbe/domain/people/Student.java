package ar.edu.utn.frc.tup.ps.psappbe.domain.people;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    public static final String OBJECT_TYPE = "STUDENT";

    private Identification universityIdentification;
    private List<Contact> universityContacts;
    private BigDecimal careerAverage;
    private LocalDate careerRegistrationDate;
    private String imageProfile;
    private AcademicStatus academicStatus;
    private Grade grade;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }}
