package todolist.project.mapper;

import todolist.project.dto.TaskCreateDto;
import todolist.project.dto.TaskResponseDto;
import todolist.project.dto.TaskUpdateDto;
import todolist.project.model.Task;

public interface TaskMapper {

    Task mapToEntity(TaskCreateDto taskCreateDto);

    TaskResponseDto mapToDto(Task task);

    void mapToDtoUpdate(TaskUpdateDto taskUpdateDto, Task task);
}
