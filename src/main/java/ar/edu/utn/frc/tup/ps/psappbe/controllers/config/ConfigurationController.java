package ar.edu.utn.frc.tup.ps.psappbe.controllers.config;


import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeFramework;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeLanguage;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.Platform;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.CodeFrameworkService;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.CodeLanguageService;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.PlatformService;
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

    private final CodeLanguageService codeLanguageService;

    private final PlatformService platformService;

    @GetMapping("/code/frameworks")
    public ResponseEntity<List<CodeFramework>> getAllCodeFramework() {
        return ResponseEntity.ok(codeFrameworkService.getAll());
    }

    @PostMapping("/code/frameworks")
    public ResponseEntity<CodeFramework> postCodeFramework(@RequestBody CodeFramework codeFramework) {
        codeFramework = codeFrameworkService.create(codeFramework);
        return ResponseEntity.created(null).body(codeFramework);
    }

    @PutMapping("/code/frameworks/{id}")
    public ResponseEntity<CodeFramework> putCodeFramework(@PathVariable Long id,
            @RequestBody CodeFramework codeFramework) {
        codeFramework = codeFrameworkService.update(codeFramework);
        return ResponseEntity.created(null).body(codeFramework);
    }

    @DeleteMapping("/code/frameworks/{id}")
    public ResponseEntity<CodeFramework> deleteCodeFramework(@PathVariable Long id) {
        CodeFramework codeFramework = codeFrameworkService.getById(id);
        if(codeFramework != null && codeFramework.isDeleted()) {
            codeFrameworkService.delete(codeFramework);
        }
        return ResponseEntity.ok(null);
    }
    @GetMapping("/code/languages")
    public ResponseEntity<List<CodeLanguage>> getAllCodeLanguage() {
        return ResponseEntity.ok(codeLanguageService.getAll());
    }

    @PostMapping("/code/languages")
    public ResponseEntity<CodeLanguage> postCodeLanguage(@RequestBody CodeLanguage codeLanguage) {
        codeLanguage = codeLanguageService.create(codeLanguage);
        return ResponseEntity.created(null).body(codeLanguage);
    }

    @PutMapping("/code/languages/{id}")
    public ResponseEntity<CodeLanguage> putCodeLanguage(@PathVariable Long id,
                                                          @RequestBody CodeLanguage codeLanguage) {
        codeLanguage = codeLanguageService.update(codeLanguage);
        return ResponseEntity.created(null).body(codeLanguage);
    }

    @DeleteMapping("/code/languages/{id}")
    public ResponseEntity<CodeLanguage> deleteCodeLanguage(@PathVariable Long id) {
        CodeLanguage codeLanguage = codeLanguageService.getById(id);
        if(codeLanguage != null && codeLanguage.isDeleted()) {
            codeLanguageService.delete(codeLanguage);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/platforms")
    public ResponseEntity<List<Platform>> getAllPlatform() {
        return ResponseEntity.ok(platformService.getAll());
    }

    @PostMapping("/platforms")
    public ResponseEntity<Platform> postPlatform(@RequestBody Platform platform) {
        platform = platformService.create(platform);
        return ResponseEntity.created(null).body(platform);
    }

    @PutMapping("/platforms/{id}")
    public ResponseEntity<Platform> putPlatform(@PathVariable Long id,
                                                        @RequestBody Platform platform) {
        platform = platformService.update(platform);
        return ResponseEntity.created(null).body(platform);
    }

    @DeleteMapping("/platforms/{id}")
    public ResponseEntity<Platform> deletePlatform(@PathVariable Long id) {
        Platform platform = platformService.getById(id);
        if(platform != null && platform.isDeleted()) {
            platformService.delete(platform);
        }
        return ResponseEntity.ok(null);
    }
}
