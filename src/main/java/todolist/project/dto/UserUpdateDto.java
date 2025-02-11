package todolist.project.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserUpdateDto {

    @Size(min = 2, max = 50)
    private String username;

    @Size(min = 2, max = 50)
    private String telegram;

    @Size(min = 2, max = 50)
    private String password;
}
