package todolist.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
public class TaskResponseDto {
    private Long id;

    private String taskName;

    private String description;

    private LocalDate createdAt;

    private LocalDate deadline;

    private String status;
}
