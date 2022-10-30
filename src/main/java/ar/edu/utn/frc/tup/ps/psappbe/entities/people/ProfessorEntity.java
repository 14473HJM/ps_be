package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Contact;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Identification;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "professors")
public class ProfessorEntity extends PersonEntity {

    @OneToOne
    @JoinColumn(name = "university_identification_id")
    private IdentificationEntity universityIdentification;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @Fetch(FetchMode.SELECT)
    private List<ContactEntity> universityContacts;
    private String universityProfile;
}
