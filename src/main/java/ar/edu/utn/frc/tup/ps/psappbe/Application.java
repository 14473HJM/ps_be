package ar.edu.utn.frc.tup.ps.psappbe;

import ar.edu.utn.frc.tup.ps.psappbe.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner run (UserRoleService userRoleService, UserService userService, PasswordEncoder passwordEncoder,
//						   UserRepository userRepository, UserRoleRepository userRoleRepository) {
//		return args -> {
//			UserRoleEntity userRoleEntity = new UserRoleEntity();
//			userRoleEntity.setName("ADMIN");
//			userRoleEntity = userRoleRepository.save(userRoleEntity);
//			UserEntity userEntity = new UserEntity();
//			userEntity.setId(1001L);
//			userEntity.setUserName("hjmorais");
//			userEntity.setPassword(passwordEncoder.encode("password"));
//			userEntity.setRoles(Arrays.asList(userRoleEntity));
//			userEntity.setEnabled(true);
//			userRepository.save(userEntity);
//		};
//	}
}
