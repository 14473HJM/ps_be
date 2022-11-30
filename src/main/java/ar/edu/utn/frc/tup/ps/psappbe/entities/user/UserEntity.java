package ar.edu.utn.frc.tup.ps.psappbe.entities.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Role;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity extends CommonFieldsEntity {

    @Column(unique=true)
    private String userName;
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role")
    @Fetch(FetchMode.JOIN)
    @Enumerated(EnumType.STRING)
    private List<Role> roles;
    private Boolean enabled;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private LocalDate passwordExpirationDate;
    private Boolean credentialExpired;
}
