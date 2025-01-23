package com.example.crudapi.controller;

import com.example.crudapi.dto.ProjectDTO;
import com.example.crudapi.service.ProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController extends BaseController<ProjectDTO> {

    public ProjectController(ProjectService projectService) {
        super(projectService);
    }
}
