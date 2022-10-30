package ar.edu.utn.frc.tup.ps.psappbe.domain.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Address;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.PlatformNetwork;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends CommonFields {

    private String name;
    private String lastName;
    private Identification personIdentification;
    private Address address;
    private LocalDate birthday;
    private Integer age;
    private PersonStatus status;
    private List<Contact> personalContacts;
    private List<PlatformNetwork> socialNetworks;
}
