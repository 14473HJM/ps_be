package ar.edu.utn.frc.tup.ps.psappbe.controllers;


import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatusAction;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ps")
@RequiredArgsConstructor
@Slf4j
@Validated
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAll(@RequestParam(required = false) Long userId) {
        if(userId != null) {
            return ResponseEntity.ok(projectService.getProjectsByUserId(userId));
        } else {
            return ResponseEntity.ok(projectService.getAll());
        }
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> postProject(@Valid @RequestBody Project project) {
        project = projectService.create(project);
        return ResponseEntity.created(null).body(project);
    }

    @PostMapping("/projects/{id}/conversation/comments")
    public ResponseEntity<Comment> publishProjectComment(@PathVariable Long id, @RequestBody Comment comment) {
        comment = projectService.publishProjectComment(id, comment);
        return ResponseEntity.created(null).body(comment);
    }

    @PutMapping("/projects/{id}/status")
    public ResponseEntity<Project> changeStatus(@PathVariable Long id,
                                                @RequestBody Comment comment,
                                                @RequestParam ProjectStatusAction action) {
        Project project = projectService.changeProjectStatus(id, comment, action);
        return ResponseEntity.created(null).body(project);
    }
}
