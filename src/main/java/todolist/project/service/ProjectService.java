package todolist.project.service;

import todolist.project.dto.ProjectCreateDto;
import todolist.project.dto.ProjectResponseDto;
import todolist.project.model.Project;

import java.util.List;

public interface ProjectService {

    Project createProject(ProjectCreateDto projectCreateDto);

    List<ProjectResponseDto> getAllProjects();

    Project getProjectById(Long id);

    Project getProjectAndAllTasks(Long id);

    Project updateProject(Long id, ProjectCreateDto projectCreateDto);

    void deleteProjectById(Long id);
}
