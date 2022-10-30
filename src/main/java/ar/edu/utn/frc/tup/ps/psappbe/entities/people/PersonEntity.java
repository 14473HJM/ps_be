package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Address;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.PlatformNetwork;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Contact;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Identification;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.PersonStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.address.AddressEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.PlatformNetworkEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity extends CommonFieldsEntity {

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

}
