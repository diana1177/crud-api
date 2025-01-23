package com.example.crudapi.controller;

import com.example.crudapi.dto.ExtendedUserDTO;
import com.example.crudapi.dto.UserDTO;
import com.example.crudapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<UserDTO> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping("/extended/{id}")
    @Operation(summary = "Get by Id")
    public ExtendedUserDTO getExtendedUserById(@PathVariable Long id) {
        return userService.getExtendedUserById(id);
    }
}
