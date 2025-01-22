package com.example.Learn_Java.service;

import com.example.Learn_Java.dto.UserDto;
import com.example.Learn_Java.dto.request.UserRequest;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    long create(UserRequest userRequest);
    long update(long id, UserRequest userRequest);
    UserDto getById(Long id);
    void deleteById(Long id);
}
