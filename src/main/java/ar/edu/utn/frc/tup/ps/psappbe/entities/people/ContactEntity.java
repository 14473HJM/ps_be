package ar.edu.utn.frc.tup.ps.psappbe.entities.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.ContactScope;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.ContactType;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
public class ContactEntity extends CommonFieldsEntity {

    @JoinColumn(name = "person_id")
    private Long personId;

    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Enumerated(EnumType.STRING)
    private ContactScope contactScope;
    private String value;
}