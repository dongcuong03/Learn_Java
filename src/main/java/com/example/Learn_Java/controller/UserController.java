package com.example.Learn_Java.controller;

import com.example.Learn_Java.dto.request.UserRequest;
import com.example.Learn_Java.dto.response.ResponseData;
import com.example.Learn_Java.dto.response.ResponseError;
import com.example.Learn_Java.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseData<?> addUser(@Valid @RequestBody UserRequest userRequest){
        try {
            long id = userService.create(userRequest);
            return new ResponseData<>(HttpStatus.CREATED.value(), "Add user sucess", id);
        }catch (Exception e){
            return  new ResponseError(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        }
    }
    @GetMapping("/getAllUser")
    public ResponseData<?> getAllUser() {
        try {
            return new ResponseData<>(HttpStatus.OK.value(), "Get all user", userService.getAllUsers());
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
    @GetMapping("getUser/{id}")
    public ResponseData<?> getUser(@PathVariable @Min(value = 1, message = "Id must be greater than 0") long id) {
        try {
            return new ResponseData<>(HttpStatus.OK.value(), "Get user by id", userService.getById(id));
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseData<?> updateUser(@PathVariable @Min(1) long id, @Valid @RequestBody UserRequest userRequest) {
        try {
            userService.update(id, userRequest);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "Update user success");
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Update user fail");
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseData<?> deleteUser(@PathVariable @Min(value = 1, message = "Id must be greater than 0") long id) {
        try {
            userService.deleteById(id);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Delete user success");
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Delete user fail");
        }
    }

}
