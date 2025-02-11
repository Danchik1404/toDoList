package todolist.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todolist.project.dto.TaskCreateDto;
import todolist.project.dto.TaskResponseDto;
import todolist.project.dto.TaskUpdateDto;
import todolist.project.enums.ExceptionMessage;
import todolist.project.enums.TaskStatus;
import todolist.project.exception.NotFoundException;
import todolist.project.mapper.TaskMapper;
import todolist.project.model.Project;
import todolist.project.model.Task;
import todolist.project.model.User;
import todolist.project.repository.TaskRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ProjectService projectService;
    private final UserService userService;

    @Override
    public TaskResponseDto createTask(TaskCreateDto taskCreateDto) {
        Project project = projectService.getProjectById(taskCreateDto.getIdProject());
        Task task = taskMapper.mapToEntity(taskCreateDto);
        task.setCreatedAt(LocalDate.now());
        task.setStatus(TaskStatus.NOT_STARTED.getStatus());
        task.setProject(project);
        return taskMapper.mapToDto(taskRepository.save(task));
    }

    @Override
    public Task getTaskById(Long id) {
        return taskFindById(id);
    }

    @Override
    public Task updateTask(Long id, TaskUpdateDto taskUpdateDto) {
        Task task = taskFindById(id);
        taskMapper.mapToDtoUpdate(taskUpdateDto, task);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        Task task = taskFindById(id);
        taskRepository.deleteById(task.getId());
    }

    @Override
    public void setTaskToUser(Long taskId, Long userId) {
        Task task = taskFindById(taskId);
        User user = userService.getUserById(userId);
        task.setUser(user);
        taskRepository.save(task);
    }

    private Task taskFindById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessage.TASK_NOT_FOUND.getMessage()));
    }
}
