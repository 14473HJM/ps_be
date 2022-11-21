package ar.edu.utn.frc.tup.ps.psappbe.domain.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends CommonFields {

    public static final String OBJECT_TYPE = "USER";

    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Person person;
    private List<Role> roles;
    private String avatar;

    @JsonIgnore
    private Boolean enabled;
    @JsonIgnore
    private Boolean accountExpired;
    @JsonIgnore
    private Boolean accountLocked;
    @JsonIgnore
    private LocalDate passwordExpirationDate;
    @JsonIgnore
    private Boolean credentialExpired;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
