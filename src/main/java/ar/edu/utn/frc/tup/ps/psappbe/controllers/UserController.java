package ar.edu.utn.frc.tup.ps.psappbe.controllers;

import ar.edu.utn.frc.tup.ps.psappbe.domain.address.Address;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.AddressService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import ar.edu.utn.frc.tup.ps.psappbe.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ps/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping()
    public ResponseEntity<User> postUserAddress(@RequestBody User user) {
        user = userService.create(user);
        return ResponseEntity.created(null).body(user);
    }
}
