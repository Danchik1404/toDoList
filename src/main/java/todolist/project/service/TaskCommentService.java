package todolist.project.service;

import todolist.project.dto.TaskCommentDto;
import todolist.project.model.TaskComment;

public interface TaskCommentService {

    TaskComment createTaskComment(TaskCommentDto taskCommentDto);

    void deleteTaskCommentById(Long id);
}
