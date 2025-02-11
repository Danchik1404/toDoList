package todolist.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todolist.project.dto.ProjectCreateDto;
import todolist.project.dto.ProjectResponseDto;
import todolist.project.enums.ExceptionMessage;
import todolist.project.exception.NotFoundException;
import todolist.project.mapper.ProjectMapper;
import todolist.project.model.Project;
import todolist.project.repository.ProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public Project createProject(ProjectCreateDto projectCreateDto) {
        Project project = projectMapper.mapToEntity(projectCreateDto);
        return projectRepository.save(project);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        List<Project> project = projectRepository.findAll();
        return projectMapper.mapToDto(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return findProjectById(id);
    }

    @Override
    public Project getProjectAndAllTasks(Long id) {
        return projectRepository.findProjectAndAllTasks(id);
    }

    @Override
    public Project updateProject(Long id, ProjectCreateDto projectCreateDto) {
        Project project = findProjectById(id);
        projectMapper.mapToEntityUpdate(projectCreateDto, project);
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(Long id) {
        Project project = findProjectById(id);
        projectRepository.deleteById(project.getId());
    }

    private Project findProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessage.PROJECT_NOT_FOUND.getMessage()));
    }
}
