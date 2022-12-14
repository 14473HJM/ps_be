package ar.edu.utn.frc.tup.ps.psappbe.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternetPlatform extends CommonFields {

    public static final String OBJECT_TYPE = "INTERNET_PLATFORM";

    private String name;
    private InternetPlatformType type;
    private String baseUrl;
    private String linkImageLogo;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
