package todolist.project.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class TaskUpdateDto {

    @Size(min = 1, max = 50)
    private String taskName;

    @Size(min = 1, max = 50)
    private String description;;

    @Size(min = 1, max = 50)
    private LocalDate deadline;
}
