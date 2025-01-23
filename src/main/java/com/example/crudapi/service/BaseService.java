package com.example.crudapi.service;

import com.example.crudapi.dto.BaseDTO;

import java.util.List;

public interface BaseService<T extends BaseDTO> {

    List<T> findAll();

     T findById(Long id);

    T save(T dto);

    void delete(Long id);
}
