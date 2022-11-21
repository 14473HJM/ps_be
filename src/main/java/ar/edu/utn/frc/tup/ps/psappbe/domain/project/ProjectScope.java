package ar.edu.utn.frc.tup.ps.psappbe.domain.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectScope {

    private Project project;
    private String scope;
}
