package ar.edu.utn.frc.tup.ps.psappbe.services.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.ContactScope;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.ContactType;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Role;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.UserRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import ar.edu.utn.frc.tup.ps.psappbe.services.mail.EmailService;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.UnavailableException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl extends BaseModelServiceImpl<User, UserEntity> implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final ContactService contactService;

    private final EmailService emailService;

    @Override
    protected JpaRepository getJpaRepository() {
        return userRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public User getByUserName(String userName) {
        Optional<UserEntity> optional = userRepository.findByUserName(userName);
        if(optional.isPresent()) {
            return modelMapper.map(optional.get(), User.class);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAll(Boolean includeDeletes) {
        List<User> users = super.getAll(includeDeletes);
        for (User user : users) {
            if(user.getPerson() != null && user.getPerson().getUniversityContacts() != null) {
                user.getPerson().setUniversityContacts(contactService.filterContacts(user.getPerson().getUniversityContacts(), ContactScope.UNIVERSITY));
            }
            if(user.getPerson() != null && user.getPerson().getPersonalContacts() != null) {
                user.getPerson().setPersonalContacts(contactService.filterContacts(user.getPerson().getPersonalContacts(), ContactScope.PERSONAL));
            }
        }
        return users;
    }

    @Override
    public Boolean isAdmin(User user) {
        return user.getRoles().stream().anyMatch((role) -> role == Role.ADMIN);
    }

    @Override
    public void changePassword(String userName, String password) {
        User user = this.getByUserName(userName);
        if(user != null) {
            user.setPassword(passwordEncoder.encode(password));
            super.update(user);
        }
    }

    @Override
    public void resetPassword(Long userId) {
        User user = this.getById(userId, true);
        if(user != null) {
            String email = user.getPerson()
                    .getUniversityContacts().stream()
                    .filter(contact -> contact.getContactType() == ContactType.EMAIL)
                    .collect(Collectors.toList())
                    .get(0)
                    .getValue();
            String password = this.getGenericPassword();
            String emailBody = String.format("Esta es su nueva password %s, puede cambairla cuando quiera.", password);
            try {
                emailService.sendSimpleEmail(email, "ps.tecnicatura@gmail.com", "Reseteo de password", emailBody);
            } catch (UnavailableException e) {
                throw new RuntimeException(e);
            }
            user.setPassword(passwordEncoder.encode(password));
            super.update(user);
        }
    }

    private String getGenericPassword() {
        int length = 15;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setPasswordExpirationDate(LocalDate.of(2030, 01, 01));
        user.setCredentialExpired(false);
        user.setAccountLocked(false);
        user.setAccountExpired(false);
        return super.create(user);
    }
}
