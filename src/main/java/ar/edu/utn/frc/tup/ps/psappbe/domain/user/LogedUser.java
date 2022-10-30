package ar.edu.utn.frc.tup.ps.psappbe.domain.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogedUser {

    private User user;
    private String token;
}
