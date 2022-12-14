package ar.edu.utn.frc.tup.ps.psappbe.domain.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User extends CommonFields {

    public static final String OBJECT_TYPE = "USER";

    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Person person;

    private List<Role> roles;
    private String avatar;

    private Boolean enabled;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private LocalDate passwordExpirationDate;
    private Boolean credentialExpired;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
