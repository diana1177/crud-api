package com.example.crudapi.service;

import com.example.crudapi.dto.ProjectDTO;
import com.example.crudapi.exception.NotFoundException;
import com.example.crudapi.mapper.ProjectMapper;
import com.example.crudapi.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService implements BaseService<ProjectDTO> {

    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> findAll() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::toProjectDTO)
                .toList();
    }

    @Override
    public ProjectDTO findById(Long id) {
        var project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find project with id: " + id));
        return ProjectMapper.toProjectDTO(project);
    }

    @Override
    public ProjectDTO save(ProjectDTO dto) {
        var project = projectRepository.save(ProjectMapper.toProject(dto));
        return ProjectMapper.toProjectDTO(project);
    }

    @Override
    @Transactional()
    public void delete(Long id) {
        var project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find project with id: " + id));

        projectRepository.delete(project);
    }
}
