package todolist.project.mapper;

import todolist.project.dto.ProjectCreateDto;
import todolist.project.dto.ProjectResponseDto;
import todolist.project.model.Project;

import java.util.List;

public interface ProjectMapper {

    Project mapToEntity(ProjectCreateDto projectCreateDto);

    void mapToEntityUpdate(ProjectCreateDto projectCreateDto, Project project);

    List<ProjectResponseDto> mapToDto(List<Project> project);
}
