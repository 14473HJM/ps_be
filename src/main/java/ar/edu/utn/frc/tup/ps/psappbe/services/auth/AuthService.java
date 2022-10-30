package ar.edu.utn.frc.tup.ps.psappbe.services.auth;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.LogedUser;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    public LogedUser getLogedUser(String userName, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        if(authentication.isAuthenticated()) {
            String token = tokenService.generateToken(authentication);
            User user = userService.getByUserName(userName);
            return new LogedUser(user, token);
        } else {
            return null;
        }
    }
}
