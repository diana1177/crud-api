package com.example.crudapi.mapper;

import com.example.crudapi.client.model.Place;
import com.example.crudapi.client.model.ZipCodeData;
import com.example.crudapi.dto.ExtendedUserDTO;
import com.example.crudapi.dto.PlaceDTO;
import com.example.crudapi.dto.UserDTO;
import com.example.crudapi.model.User;
import jdk.dynalink.Operation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .zipCode(user.getZipCode())
                .taskList(Optional.ofNullable(user.getTaskList()).stream()
                        .flatMap(Collection::stream)
                        .map(TaskMapper::toTaskDTO)
                        .toList())
                .build();
    }

    public static ExtendedUserDTO toExtendedUserDTO(User user, ZipCodeData zipCodeData) {
        return ExtendedUserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .zipCode(user.getZipCode())
                .taskList(Optional.ofNullable(user.getTaskList()).stream()
                        .flatMap(Collection::stream)
                        .map(TaskMapper::toTaskDTO)
                        .toList())
                .country(zipCodeData.getCountry())
                .places(Optional.ofNullable(zipCodeData.getPlaces()).stream()
                        .flatMap(Collection::stream)
                        .map(UserMapper::toPlaceDto)
                        .toList())
                .build();
    }

    public static User toUser(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .zipCode(userDTO.getZipCode())
                .build();
    }

    public static PlaceDTO toPlaceDto(Place place) {
        return PlaceDTO.builder()
                .placeName(place.getPlaceName())
                .longitude(place.getLongitude())
                .latitude(place.getLatitude())
                .state(place.getState())
                .build();
    }
}
