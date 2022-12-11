package ar.edu.utn.frc.tup.ps.psappbe.controllers.config;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.InternetPlatform;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.Cohort;
import ar.edu.utn.frc.tup.ps.psappbe.services.config.InternetPlatformService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.CohortService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ps/config/cohorts")
@RequiredArgsConstructor
@Slf4j
public class CohortController {

    private final CohortService cohortService;

    @GetMapping()
    public ResponseEntity<List<Cohort>> getAll() {
        return ResponseEntity.ok(cohortService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Cohort> post(@RequestBody Cohort element) {
        element = cohortService.create(element);
        return ResponseEntity.created(null).body(element);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cohort> put(@PathVariable Long id,
                                      @RequestBody Cohort element) {
        element = cohortService.update(element);
        return ResponseEntity.created(null).body(element);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cohort> delete(@PathVariable Long id) {
        Cohort element = cohortService.getById(id);
        if(element != null && !element.isDeleted()) {
            cohortService.delete(element);
        }
        return ResponseEntity.ok(null);
    }
}
