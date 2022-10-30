package ar.edu.utn.frc.tup.ps.psappbe.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformNetwork {

    private InternetPlatform internetPlatform;
    private String profileName;
}
