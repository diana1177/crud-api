package com.example.crudapi.service;

import com.example.crudapi.client.ZipCodeClient;
import com.example.crudapi.dto.ExtendedUserDTO;
import com.example.crudapi.dto.UserDTO;
import com.example.crudapi.exception.NotFoundException;
import com.example.crudapi.mapper.UserMapper;
import com.example.crudapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements BaseService<UserDTO> {

    private UserRepository userRepository;

    private ZipCodeClient zipCodeClient;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserDTO)
                .toList();
    }

    @Override
    public UserDTO findById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + id));
        return UserMapper.toUserDTO(user);
    }

    public ExtendedUserDTO getExtendedUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + id));

        var zipCodeData = zipCodeClient.getZipCodeInformation(user.getZipCode());

        return UserMapper.toExtendedUserDTO(user, zipCodeData);
    }

    @Override
    public UserDTO save(UserDTO dto) {
        var user = userRepository.save(UserMapper.toUser(dto));
        return UserMapper.toUserDTO(user);
    }

    @Override
    public void delete(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + id));

        userRepository.delete(user);
    }
}
