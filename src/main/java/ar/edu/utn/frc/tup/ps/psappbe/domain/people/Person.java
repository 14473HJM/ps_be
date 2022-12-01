package ar.edu.utn.frc.tup.ps.psappbe.domain.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Address;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.common.PlatformNetwork;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.ContactEntity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "objectType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Student.class, name = "STUDENT"),
        @JsonSubTypes.Type(value = Professor.class, name = "PROFESSOR")
})
public class Person extends CommonFields {

    public static final String OBJECT_TYPE = "PERSON";

    private String role;
    private String name;
    private String lastName;
    private Identification personIdentification;
    private Address address;
    private LocalDate birthday;
    private Integer age;
    private PersonStatus status;
    private List<Contact> personalContacts;
    private List<PlatformNetwork> socialNetworks;
    private List<Contact> universityContacts;
    private String imageProfile;
    private Identification universityIdentification;
    private User user;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
