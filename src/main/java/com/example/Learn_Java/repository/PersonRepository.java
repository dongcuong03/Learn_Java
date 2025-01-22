package com.example.Learn_Java.repository;

import com.example.Learn_Java.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}
