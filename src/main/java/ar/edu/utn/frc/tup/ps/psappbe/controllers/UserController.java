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
import java.util.Optional;

@RestController
@RequestMapping("/ps/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id, @RequestParam Optional<Boolean> includeDeletes) {
        User user = userService.getById(id, includeDeletes.orElse(false));
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(@RequestParam Optional<Boolean> includeDeletes) {
        List<User> users = userService.getAll(includeDeletes.orElse(false));
        return ResponseEntity.ok(users);
    }

    @PostMapping()
    public ResponseEntity<User> postUser(@RequestBody User user) {
        user = userService.create(user);
        return ResponseEntity.created(null).body(user);
    }
}
