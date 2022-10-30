package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPresentation extends CommonFields {

    private String presentationVideoLink;
    private String demoVideoLink;
    private Attachment finalDocument;
    private String deliveryLink;

}
