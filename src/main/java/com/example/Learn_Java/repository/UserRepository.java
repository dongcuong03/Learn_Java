package com.example.Learn_Java.repository;

import com.example.Learn_Java.domain.User;
import com.example.Learn_Java.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    @Query(value = "select new com.example.Learn_Java.dto.UserDto(u) from User u")
    List<UserDto> getAll ();

}
