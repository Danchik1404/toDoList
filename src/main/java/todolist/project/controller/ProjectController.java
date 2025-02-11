package todolist.project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import todolist.project.dto.ProjectCreateDto;
import todolist.project.dto.ProjectResponseDto;
import todolist.project.model.Project;
import todolist.project.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/to-do-list/projects")
@Validated
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> ProjectCreate(@Valid @RequestBody ProjectCreateDto projectCreateDto) {
        Project project = projectService.createProject(projectCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity <Project> getProjectAndAllTasks(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectAndAllTasks(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectCreateDto projectCreateDto) {
        Project project = projectService.updateProject(id, projectCreateDto);
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable Long id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
