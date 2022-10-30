package ar.edu.utn.frc.tup.ps.psappbe.controllers;

import ar.edu.utn.frc.tup.ps.psappbe.domain.user.LogedUser;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.Login;
import ar.edu.utn.frc.tup.ps.psappbe.services.auth.AuthService;
import ar.edu.utn.frc.tup.ps.psappbe.services.auth.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LogedUser> login(@RequestBody Login login) {
        return ResponseEntity.ok(authService.getLogedUser(login.userName(), login.password()));
    }

}
