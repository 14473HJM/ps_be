package ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conversation extends CommonFields {

    private List<Comment> comments;

}
