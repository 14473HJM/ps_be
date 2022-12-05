package ar.edu.utn.frc.tup.ps.psappbe.controllers.config;


import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeFramework;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.CodeFrameworkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ps/config")
@RequiredArgsConstructor
@Slf4j
public class ConfigurationController {

    private final CodeFrameworkService codeFrameworkService;

    @GetMapping("/code/frameworks")
    public ResponseEntity<List<CodeFramework>> getAll() {
        return ResponseEntity.ok(codeFrameworkService.getAll());
    }

    @PostMapping("/code/frameworks")
    public ResponseEntity<CodeFramework> post(@RequestBody CodeFramework codeFramework) {
        codeFramework = codeFrameworkService.create(codeFramework);
        return ResponseEntity.created(null).body(codeFramework);
    }

    @PutMapping("/code/frameworks/{id}")
    public ResponseEntity<CodeFramework> put(@PathVariable Long id,
            @RequestBody CodeFramework codeFramework) {
        codeFramework = codeFrameworkService.update(codeFramework);
        return ResponseEntity.created(null).body(codeFramework);
    }
}
