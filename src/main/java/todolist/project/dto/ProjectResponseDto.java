package todolist.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ProjectResponseDto {

    private Long id;

    private String projectName;
}
