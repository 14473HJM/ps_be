package ar.edu.utn.frc.tup.ps.psappbe.controllers.config;


import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeFramework;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.CodeFrameworkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
@Slf4j
public class ConfigurationController {

    private final CodeFrameworkService codeFrameworkService;

    @GetMapping("/code/frameworks")
    public ResponseEntity<List<CodeFramework>> getAll() {
        return ResponseEntity.ok(codeFrameworkService.getAll());
    }
}
