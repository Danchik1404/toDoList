package todolist.project.mapper;

import todolist.project.dto.TaskCommentDto;
import todolist.project.model.TaskComment;

public interface TaskCommentMapper {

    TaskComment mapToEntity(TaskCommentDto taskCommentDto);
}
