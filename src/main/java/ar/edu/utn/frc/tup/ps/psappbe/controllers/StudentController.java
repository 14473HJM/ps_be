package ar.edu.utn.frc.tup.ps.psappbe.controllers;


import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ps/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Student> post(@RequestBody Student student) {
        student = studentService.create(student);
        return ResponseEntity.created(null).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> put(
            @PathVariable Long id,
            @RequestBody Student student) {
        student = studentService.update(student);
        return ResponseEntity.ok(student);
    }
}
