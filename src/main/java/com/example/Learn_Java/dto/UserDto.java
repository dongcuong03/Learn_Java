package com.example.Learn_Java.dto;

import com.example.Learn_Java.domain.User;

public class UserDto {
    private Long id;
    private String email;
    private String password;
    private Boolean isActive;
    private PersonDto person;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password =  user.getPassword();
        this.isActive = user.getIsActive();
        this.person = new PersonDto(user.getPerson());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }
}
