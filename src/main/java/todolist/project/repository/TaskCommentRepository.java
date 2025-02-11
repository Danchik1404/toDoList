package todolist.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.project.model.TaskComment;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {
}
