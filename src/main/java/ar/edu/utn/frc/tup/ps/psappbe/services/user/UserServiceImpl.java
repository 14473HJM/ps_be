package ar.edu.utn.frc.tup.ps.psappbe.services.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.ContactScope;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Role;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.UserRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl extends BaseModelServiceImpl<User, UserEntity> implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final ContactService contactService;
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
    public List<User> getAll() {
        List<User> users = super.getAll();
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
