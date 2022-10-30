package ar.edu.utn.frc.tup.ps.psappbe.domain.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInterface extends CommonFields {

    /**
     * WEB, MOBILE, DESKTOP
     */

    private String type;
    private String name;
}
