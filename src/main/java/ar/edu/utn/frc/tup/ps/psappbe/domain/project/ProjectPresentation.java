package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPresentation extends CommonFields {

    public static final String OBJECT_TYPE = "PROJECT_PRESENTATION";

    private String presentationVideoLink;
    private String demoVideoLink;
    private String finalDocumentLink;
    private String deliveryLink;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
