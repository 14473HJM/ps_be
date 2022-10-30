package ar.edu.utn.frc.tup.ps.psappbe.domain.people;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    private Long id;
    private String turn;
    private String number;
    private String name;
}
