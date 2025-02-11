package todolist.project.mapper;

import org.springframework.stereotype.Component;
import todolist.project.dto.TaskCreateDto;
import todolist.project.dto.TaskResponseDto;
import todolist.project.dto.TaskUpdateDto;
import todolist.project.model.Task;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task mapToEntity(TaskCreateDto taskCreateDto) {
        return Task.builder()
                .taskName(taskCreateDto.getTaskName())
                .description(taskCreateDto.getDescription())
                .deadline(taskCreateDto.getDeadline())
                .build();
    }

    @Override
    public TaskResponseDto mapToDto(Task task) {
        return TaskResponseDto.builder()
                .id(task.getId())
                .taskName(task.getTaskName())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .deadline(task.getDeadline())
                .status(task.getStatus())
                .build();
    }

    @Override
    public void mapToDtoUpdate(TaskUpdateDto taskUpdateDto, Task task) {
        if (taskUpdateDto.getTaskName() != null) {
            task.setTaskName(taskUpdateDto.getTaskName());
        }
        if (taskUpdateDto.getDescription() != null) {
            task.setDescription(taskUpdateDto.getDescription());
        }
        if (taskUpdateDto.getDeadline() != null) {
            task.setDeadline(taskUpdateDto.getDeadline());
        }
    }
}
