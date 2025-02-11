package todolist.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todolist.project.dto.TaskCommentDto;
import todolist.project.enums.ExceptionMessage;
import todolist.project.exception.NotFoundException;
import todolist.project.mapper.TaskCommentMapper;
import todolist.project.model.Task;
import todolist.project.model.TaskComment;
import todolist.project.repository.TaskCommentRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskCommentServiceImpl implements TaskCommentService {

    private final TaskCommentRepository taskCommentRepository;
    private final TaskCommentMapper taskCommentMapper;
    private final TaskService taskService;

    @Override
    public TaskComment createTaskComment(TaskCommentDto taskCommentDto) {
        Task task = taskService.getTaskById(taskCommentDto.getTaskId());
        TaskComment taskComment = taskCommentMapper.mapToEntity(taskCommentDto);
        taskComment.setCreatedAt(LocalDate.now());
        taskComment.setTask(task);
        return taskCommentRepository.save(taskComment);
    }

    @Override
    public void deleteTaskCommentById(Long id) {
        TaskComment taskComment = findTaskCommentById(id);
        taskCommentRepository.deleteById(taskComment.getId());
    }

    private TaskComment findTaskCommentById(Long id) {
        return taskCommentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessage.TASK_COMMENT_NOT_FOUND.getMessage()));
    }
}
