package todolist.project.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class TaskCreateDto {

    @NotNull
    @Size(min = 1, max = 50)
    private String taskName;

    @NotNull
    @Size(min = 1, max = 300)
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDate deadline;

    @NotNull
    private Long idProject;
}
