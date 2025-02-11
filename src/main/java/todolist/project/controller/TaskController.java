package todolist.project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import todolist.project.dto.TaskCreateDto;
import todolist.project.dto.TaskResponseDto;
import todolist.project.dto.TaskUpdateDto;
import todolist.project.model.Task;
import todolist.project.service.TaskService;

@RestController
@RequestMapping("/to-do-list/projects/tasks")
@Validated
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> TaskCreate(@Valid @RequestBody TaskCreateDto taskCreateDto) {
        TaskResponseDto taskResponseDto = taskService.createTask(taskCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskUpdateDto taskUpdateDto) {
        Task task = taskService.updateTask(id, taskUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PatchMapping("/{taskId}/{userId}")
    public ResponseEntity<Task> setTaskToUser(@PathVariable Long taskId, @PathVariable Long userId) {
        taskService.setTaskToUser(taskId, userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
