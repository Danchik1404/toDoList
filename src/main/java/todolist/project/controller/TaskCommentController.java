package todolist.project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import todolist.project.dto.TaskCommentDto;
import todolist.project.model.TaskComment;
import todolist.project.service.TaskCommentService;

@RestController
@RequestMapping("/to-do-list/projects/tasks/comment")
@Validated
@RequiredArgsConstructor
public class TaskCommentController {

    private final TaskCommentService taskCommentService;

    @PostMapping
    public ResponseEntity<TaskComment> TaskCommentCreate(@Valid @RequestBody TaskCommentDto taskCommentDto) {
        TaskComment taskComment = taskCommentService.createTaskComment(taskCommentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskCommentById(@PathVariable Long id) {
        taskCommentService.deleteTaskCommentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
