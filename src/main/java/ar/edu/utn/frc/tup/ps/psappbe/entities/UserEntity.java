package ar.edu.utn.frc.tup.ps.psappbe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String userName;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = EAGER)
    private List<UserRoleEntity> roles;
    private Boolean enabled;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private LocalDate passwordExpirationDate;
    private Boolean credentialExpired;
}
