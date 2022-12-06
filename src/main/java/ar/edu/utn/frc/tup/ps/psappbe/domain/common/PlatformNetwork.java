package ar.edu.utn.frc.tup.ps.psappbe.domain.common;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformNetwork extends CommonFields {

    public static final String OBJECT_TYPE = "PLATFORM_NETWORK";

    @JsonBackReference
    private Person person;
    private InternetPlatform internetPlatform;
    private String profileName;

    @Override
    public String getObjectTypeName() {
        return this.OBJECT_TYPE;
    }
}
