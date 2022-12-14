package ar.edu.utn.frc.tup.ps.psappbe.controllers;


import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.ProfessorService;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ps/professors")
@RequiredArgsConstructor
@Slf4j
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping()
    public ResponseEntity<List<Professor>> getAll(@RequestParam Optional<Boolean> includeDeletes) {
        return ResponseEntity.ok(professorService.getAll(includeDeletes.orElse(false)));
    }

    @PostMapping()
    public ResponseEntity<Professor> post(@RequestBody Professor professor) {
        professor = professorService.create(professor);
        return ResponseEntity.created(null).body(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> put(
            @PathVariable Long id,
            @RequestBody Professor professor) {
        professor = professorService.update(professor);
        return ResponseEntity.ok(professor);
    }
}
