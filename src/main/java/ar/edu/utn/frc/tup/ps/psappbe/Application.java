package ar.edu.utn.frc.tup.ps.psappbe;

import ar.edu.utn.frc.tup.ps.psappbe.config.RsaKeyProperties;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.UserRole;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserRoleEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.UserRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.UserRoleRepository;
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

	@Bean
	CommandLineRunner run (UserRoleService userRoleService, UserService userService, PasswordEncoder passwordEncoder,
						   UserRepository userRepository, UserRoleRepository userRoleRepository) {
		return args -> {
			UserRoleEntity userRoleEntity = new UserRoleEntity();
			userRoleEntity.setId(1L);
			UserEntity userEntity = new UserEntity();
			userEntity.setId(1001L);
			userEntity.setUserName("hjmorais");
			userEntity.setPassword(passwordEncoder.encode("password"));
			userEntity.setRoles(Arrays.asList(userRoleEntity));
			userEntity.setEnabled(true);
			userRepository.save(userEntity);
		};
	}
}
