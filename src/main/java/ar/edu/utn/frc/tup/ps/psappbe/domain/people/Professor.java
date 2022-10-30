package ar.edu.utn.frc.tup.ps.psappbe.domain.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    private Identification universityIdentification;
    private List<Contact> universityContacts;
    private String universityProfile;
}
