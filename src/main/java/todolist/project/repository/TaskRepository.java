package todolist.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.project.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
