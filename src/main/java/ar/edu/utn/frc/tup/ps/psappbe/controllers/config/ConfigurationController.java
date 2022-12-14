package ar.edu.utn.frc.tup.ps.psappbe.controllers.config;


import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeFramework;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeLanguage;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.Platform;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.Technology;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.CodeFrameworkService;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.CodeLanguageService;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.PlatformService;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.TechnologyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ps/config")
@RequiredArgsConstructor
@Slf4j
public class ConfigurationController {

    private final CodeFrameworkService codeFrameworkService;

    private final CodeLanguageService codeLanguageService;

    private final PlatformService platformService;

    private final TechnologyService technologyService;

    @GetMapping("/code/frameworks")
    public ResponseEntity<List<CodeFramework>> getAllCodeFramework(@RequestParam Optional<Boolean> includeDeletes) {
        return ResponseEntity.ok(codeFrameworkService.getAll(includeDeletes.orElse(false)));
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
        CodeFramework codeFramework = codeFrameworkService.getById(id, true);
        if(codeFramework != null && !codeFramework.isDeleted()) {
            codeFrameworkService.delete(codeFramework);
        }
        return ResponseEntity.ok(null);
    }
    @GetMapping("/code/languages")
    public ResponseEntity<List<CodeLanguage>> getAllCodeLanguage(@RequestParam Optional<Boolean> includeDeletes) {
        return ResponseEntity.ok(codeLanguageService.getAll(includeDeletes.orElse(false)));
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
        CodeLanguage codeLanguage = codeLanguageService.getById(id, true);
        if(codeLanguage != null && !codeLanguage.isDeleted()) {
            codeLanguageService.delete(codeLanguage);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/platforms")
    public ResponseEntity<List<Platform>> getAllPlatform(@RequestParam Optional<Boolean> includeDeletes) {
        return ResponseEntity.ok(platformService.getAll(includeDeletes.orElse(false)));
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
        Platform platform = platformService.getById(id, true);
        if(platform != null && !platform.isDeleted()) {
            platformService.delete(platform);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/technologies")
    public ResponseEntity<List<Technology>> getAllTechnology(@RequestParam Optional<Boolean> includeDeletes) {
        return ResponseEntity.ok(technologyService.getAll(includeDeletes.orElse(false)));
    }

    @PostMapping("/technologies")
    public ResponseEntity<Technology> postTechnology(@RequestBody Technology technology) {
        technology = technologyService.create(technology);
        return ResponseEntity.created(null).body(technology);
    }

    @PutMapping("/technologies/{id}")
    public ResponseEntity<Technology> putTechnology(@PathVariable Long id,
                                                @RequestBody Technology technology) {
        technology = technologyService.update(technology);
        return ResponseEntity.created(null).body(technology);
    }

    @DeleteMapping("/technologies/{id}")
    public ResponseEntity<Technology> deleteTechnology(@PathVariable Long id) {
        Technology technology = technologyService.getById(id, true);
        if(technology != null && !technology.isDeleted()) {
            technologyService.delete(technology);
        }
        return ResponseEntity.ok(null);
    }
}
