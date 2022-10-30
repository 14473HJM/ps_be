package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "grades")
public class GradeEntity extends CommonFieldsEntity {

    private String turn;
    private String number;
    private String name;
}