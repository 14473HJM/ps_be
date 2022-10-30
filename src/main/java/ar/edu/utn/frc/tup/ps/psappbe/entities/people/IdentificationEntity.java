package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.IdentificationType;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "identifications")
public class IdentificationEntity extends CommonFieldsEntity {

    @Enumerated(EnumType.STRING)
    private IdentificationType identificationType;
    private String identification;

}