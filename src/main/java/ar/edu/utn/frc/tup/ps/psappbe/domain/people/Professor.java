package ar.edu.utn.frc.tup.ps.psappbe.domain.people;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("professor")
public class Professor {

    public static final String OBJECT_TYPE = "PROFESSOR";

    private Identification universityIdentification;
    private List<Contact> universityContacts;
    private String universityProfile;
}