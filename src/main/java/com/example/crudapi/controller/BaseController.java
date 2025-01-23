package com.example.crudapi.controller;

import com.example.crudapi.dto.BaseDTO;
import com.example.crudapi.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseController<T extends BaseDTO> {

    private BaseService<T> baseService;

    @GetMapping("/")
    @Operation(summary = "Get all")
    public List<T> getAll() {
        return baseService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by id")
    public T getById(@PathVariable Long id) {
        return baseService.findById(id);
    }

    @PostMapping("/")
    @Operation(summary = "Save")
    public T save(@Valid @RequestBody T body) {
        return baseService.save(body);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete by Ii")
    public void delete(@PathVariable Long id) {
        baseService.delete(id);
    }
}
