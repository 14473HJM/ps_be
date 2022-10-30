package ar.edu.utn.frc.tup.ps.psappbe.domain.user;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Login(@JsonAlias({ "username", "user_name" }) String userName, String password) {
}
