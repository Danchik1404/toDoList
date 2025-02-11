package todolist.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProjectCreateDto {

    @NotNull
    @Size(min = 1, max = 50)
    private String projectName;
}
