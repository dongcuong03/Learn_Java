package com.example.Learn_Java.dto;

import com.example.Learn_Java.domain.Person;
import com.example.Learn_Java.domain.User;

import java.time.LocalDate;

public class PersonDto {
    private Long id;
    private String fullName;
    private String gender;
    private LocalDate birthdate;
    private String phoneNumber;
    private String address;

    public PersonDto() {
    }
    public PersonDto(Person person){
        this.id = person.getId();
        this.fullName = person.getFullName();
        this.gender = person.getGender();
        this.birthdate = person.getBirthdate();
        this.phoneNumber = person.getPhoneNumber();
        this.address = person.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
