package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectScope {

    private Project project;

    @NotBlank(message = "Cada alcance del proyecto debe tener al menos 1 caracter distinto de espacios en blanco")
    private String scope;
}
