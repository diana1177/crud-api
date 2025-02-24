package com.example.crudapi.mapper;

import com.example.crudapi.dto.ProjectDTO;
import com.example.crudapi.model.Project;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectMapper {

    public static ProjectDTO toProjectDTO(Project project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .description(project.getDescription())
                .title(project.getTitle())
                .taskList(Optional.ofNullable(project.getTaskList()).stream()
                        .flatMap(Collection::stream)
                        .map(TaskMapper::toTaskDTO)
                        .toList())
                .build();
    }

    public static Project toProject(ProjectDTO projectDTO) {
        return Project.builder()
                .description(projectDTO.getDescription())
                .title(projectDTO.getTitle())
                .build();
    }
}
