package todolist.project.mapper;

import org.springframework.stereotype.Component;
import todolist.project.dto.ProjectCreateDto;
import todolist.project.dto.ProjectResponseDto;
import todolist.project.model.Project;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project mapToEntity(ProjectCreateDto projectCreateDto) {
        return Project.builder()
                .projectName(projectCreateDto.getProjectName())
                .build();
    }

    @Override
    public void mapToEntityUpdate(ProjectCreateDto projectCreateDto, Project project) {
        project.setProjectName(projectCreateDto.getProjectName());
    }

    @Override
    public List<ProjectResponseDto> mapToDto(List<Project> projects) {
        return projects.stream()
                .map(project -> ProjectResponseDto.builder()
                        .id(project.getId())
                        .projectName(project.getProjectName())
                        .build())
                .collect(Collectors.toList());
    }
}
