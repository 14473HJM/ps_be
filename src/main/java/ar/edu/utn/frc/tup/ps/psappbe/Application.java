package ar.edu.utn.frc.tup.ps.psappbe;

import ar.edu.utn.frc.tup.ps.psappbe.config.RsaKeyProperties;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.*;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Role;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.UserRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.IdentificationService;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.ProfessorService;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.StudentService;
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
	CommandLineRunner run (UserService userService,
						   ProfessorService professorService, StudentService studentService,
						   IdentificationService identificationService) {
		return args -> {
			User adminUser = userService.getByUserName("100000");
			if(adminUser == null) {
				adminUser = createUserAdmin("password");
				Identification i = identificationService.create(adminUser.getPerson().getUniversityIdentification());
				adminUser.getPerson().getUniversityIdentification().setId(i.getId());
				Person p = professorService.create((Professor) adminUser.getPerson());
				adminUser.getPerson().setId(p.getId());
				userService.create(adminUser);
			}
			User studentUser = userService.getByUserName("100001");
			if(studentUser == null) {

				Person p = studentService.create(createUserStudent("password"));
			}
			User professorUser = userService.getByUserName("100002");
			if(professorUser == null) {
				professorUser = createUserProfessor("password");
				Identification i = identificationService.create(professorUser.getPerson().getUniversityIdentification());
				professorUser.getPerson().getUniversityIdentification().setId(i.getId());
				Person p = professorService.create((Professor) professorUser.getPerson());
				professorUser.getPerson().setId(p.getId());
				userService.create(professorUser);
			}
		};
	}

	private User createUserAdmin(String password) {
		Person person = new Professor();
		person.setName("Test");
		person.setLastName("Administrador");
		person.setStatus(PersonStatus.ACTIVE);
		person.setUniversityIdentification(new Identification("100000", IdentificationType.LEGAJO));
		User user = new User();
		user.setUserName("100000");
		user.setPassword(password);
		user.setRoles(Arrays.asList(Role.ADMIN));
		user.setAccountExpired(false);
		user.setAccountLocked(false);
		user.setCredentialExpired(false);
		user.setPasswordExpirationDate(LocalDate.of(2030, 01, 01));
		user.setEnabled(true);
		user.setPerson(person);
		return user;
	}

	private Student createUserStudent(String password) {
		Student person = new Student();
		person.setName("Test");
		person.setLastName("Student");
		person.setStatus(PersonStatus.ACTIVE);
		person.setUniversityIdentification(new Identification("100001", IdentificationType.LEGAJO));
		person.setPersonIdentification(new Identification("11111111", IdentificationType.DNI));
		person.setObjectType("STUDENT");
		User user = new User();
		user.setUserName("100001");
		user.setPassword(password);
		person.setUser(user);
		return person;
	}

	private User createUserProfessor(String password) {
		Person person = new Professor();
		person.setName("Test");
		person.setLastName("Professor");
		person.setStatus(PersonStatus.ACTIVE);
		person.setUniversityIdentification(new Identification("100002", IdentificationType.LEGAJO));
		User user = new User();
		user.setUserName("100002");
		user.setPassword(password);
		user.setRoles(Arrays.asList(Role.PROFESSOR));
		user.setAccountExpired(false);
		user.setAccountLocked(false);
		user.setCredentialExpired(false);
		user.setPasswordExpirationDate(LocalDate.of(2030, 01, 01));
		user.setEnabled(true);
		user.setPerson(person);
		return user;
	}
}
