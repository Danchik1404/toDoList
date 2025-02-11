package todolist.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskCommentDto {

    @NotNull
    @Size(min = 1, max = 200)
    private String text;

    @NotNull
    private Long taskId;
}
