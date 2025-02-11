package todolist.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserCreateDto {

    @Size(min = 2, max = 50)
    @NotNull
    private String username;

    @Size(min = 2, max = 50)
    @NotNull
    private String telegram;

    @Size(min = 2, max = 50)
    @NotNull
    private String password;
}
