package ar.edu.utn.frc.tup.ps.psappbe;

import ar.edu.utn.frc.tup.ps.psappbe.config.RsaKeyProperties;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.UserRole;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserRoleService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
