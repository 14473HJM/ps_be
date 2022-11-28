package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectScope extends CommonFields {

    @JsonIgnore
    public static final String OBJECT_TYPE = "PROJECT_SCOPE";

    private Long projectId;

    @NotBlank(message = "Cada alcance del proyecto debe tener al menos 1 caracter distinto de espacios en blanco")
    private String scope;

    @Override
    public String getObjectTypeName() {
        return OBJECT_TYPE;
    }
}
