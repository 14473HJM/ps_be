package ar.edu.utn.frc.tup.ps.psappbe.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<UserRole> roles;
    private Boolean enabled;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private LocalDate passwordExpirationDate;
    private Boolean credentialExpired;

}
