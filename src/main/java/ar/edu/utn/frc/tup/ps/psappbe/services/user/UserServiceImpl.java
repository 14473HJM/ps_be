package ar.edu.utn.frc.tup.ps.psappbe.services.user;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.UserRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl extends BaseModelServiceImpl<User, UserEntity> implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;
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
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return super.create(user);
    }
}
