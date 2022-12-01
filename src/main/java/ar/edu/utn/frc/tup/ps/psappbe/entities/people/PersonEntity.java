package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Address;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.PlatformNetwork;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Contact;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Identification;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.PersonStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.address.AddressEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.PlatformNetworkEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "people")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role",
        discriminatorType = DiscriminatorType.STRING)
public class PersonEntity extends CommonFieldsEntity {

    @Column(insertable = false, updatable = false)
    private String role;
    private String name;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "person_identification_id")
    private IdentificationEntity personIdentification;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private PersonStatus status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @Fetch(FetchMode.SELECT)
    private List<ContactEntity> personalContacts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @Fetch(FetchMode.SELECT)
    private List<PlatformNetworkEntity> socialNetworksEntity;

    @OneToOne
    @JoinColumn(name = "university_identification_id")
    private IdentificationEntity universityIdentification;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @Fetch(FetchMode.SELECT)
    private List<ContactEntity> universityContacts;

    private String imageProfile;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
