package ar.edu.utn.frc.tup.ps.psappbe.controllers.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import ar.edu.utn.frc.tup.ps.psappbe.domain.config.CodeFramework;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.InternetPlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ps/config/internet/platforms")
@RequiredArgsConstructor
@Slf4j
public class InternetPlatformController {

    private final InternetPlatformService internetPlatformService;

    @GetMapping()
    public ResponseEntity<List<InternetPlatform>> getAll() {
        return ResponseEntity.ok(internetPlatformService.getAll());
    }

    @PostMapping()
    public ResponseEntity<InternetPlatform> post(@RequestBody InternetPlatform element) {
        element = internetPlatformService.create(element);
        return ResponseEntity.created(null).body(element);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternetPlatform> put(@PathVariable Long id,
                                                          @RequestBody InternetPlatform element) {
        element = internetPlatformService.update(element);
        return ResponseEntity.created(null).body(element);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InternetPlatform> delete(@PathVariable Long id) {
        InternetPlatform element = internetPlatformService.getById(id);
        if(element != null && !element.isDeleted()) {
            internetPlatformService.delete(element);
        }
        return ResponseEntity.ok(null);
    }
}
