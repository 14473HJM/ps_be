package ar.edu.utn.frc.tup.ps.psappbe.entities.address;

import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Country;
import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Province;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "addresses")
public class AddressEntity extends CommonFieldsEntity {

    private String street;
    private String streetNumber;
    private String zipCode;
    private String detail;
    private String city;

    @Enumerated(EnumType.STRING)
    private Province province;
    @Enumerated(EnumType.STRING)
    private Country country;
}