package com.example.crudapi.mapper;

import com.example.crudapi.dto.TaskDTO;
import com.example.crudapi.model.Task;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskMapper {

    public static TaskDTO toTaskDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .description(task.getDescription())
                .name(task.getName())
                .status(task.getStatus())
                .build();
    }

    public static Task toTask(TaskDTO taskDTO) {
        return Task.builder()
                .description(taskDTO.getDescription())
                .name(taskDTO.getName())
                .status(taskDTO.getStatus())
                .build();
    }
}
