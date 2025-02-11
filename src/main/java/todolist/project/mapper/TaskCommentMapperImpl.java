package todolist.project.mapper;

import org.springframework.stereotype.Component;
import todolist.project.dto.TaskCommentDto;
import todolist.project.model.TaskComment;

@Component
public class TaskCommentMapperImpl implements TaskCommentMapper {

    @Override
    public TaskComment mapToEntity(TaskCommentDto taskCommentDto) {
        return TaskComment.builder()
                .text(taskCommentDto.getText())
                .build();
    }
}
