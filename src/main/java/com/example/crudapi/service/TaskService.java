package com.example.crudapi.service;

import com.example.crudapi.dto.TaskDTO;
import com.example.crudapi.exception.NotFoundException;
import com.example.crudapi.mapper.TaskMapper;
import com.example.crudapi.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService implements BaseService<TaskDTO> {

    private TaskRepository taskRepository;

    @Override
    public List<TaskDTO> findAll() {
        return taskRepository.findAll().stream()
                .map(TaskMapper::toTaskDTO)
                .toList();
    }

    @Override
    public TaskDTO findById(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find task with id: " + id));
        return TaskMapper.toTaskDTO(task);
    }

    @Override
    public TaskDTO save(TaskDTO dto) {
        var task = taskRepository.save(TaskMapper.toTask(dto));
        return TaskMapper.toTaskDTO(task);
    }

    @Override
    public void delete(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find task with id: " + id));

        taskRepository.delete(task);
    }
}
