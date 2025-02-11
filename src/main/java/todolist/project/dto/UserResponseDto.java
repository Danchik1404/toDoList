package todolist.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class UserResponseDto {

    private Long id;

    private String username;

    private String telegram;

    private String role;
}
