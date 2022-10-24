package ar.edu.utn.frc.tup.ps.psappbe.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ps")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Admin");
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping("/user")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("User");
    }

    @GetMapping("/projects")
    public ResponseEntity<String> getProjects() {
        return ResponseEntity.ok("Projects");
    }
}
