package ar.edu.utn.frc.tup.ps.psappbe.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
}
