package todolist.project.service;

import todolist.project.dto.TaskCreateDto;
import todolist.project.dto.TaskResponseDto;
import todolist.project.dto.TaskUpdateDto;
import todolist.project.model.Task;

public interface TaskService {

    TaskResponseDto createTask(TaskCreateDto taskCreateDto);

    Task getTaskById(Long id);

    Task updateTask(Long id, TaskUpdateDto taskUpdateDto);

    void deleteTaskById(Long id);

    void setTaskToUser(Long taskId, Long userId);
}
