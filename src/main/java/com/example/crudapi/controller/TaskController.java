package com.example.crudapi.controller;

import com.example.crudapi.dto.TaskDTO;
import com.example.crudapi.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController extends BaseController<TaskDTO> {

    public TaskController(TaskService taskService) {
        super(taskService);
    }
}
