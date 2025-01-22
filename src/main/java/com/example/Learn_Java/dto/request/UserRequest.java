package com.example.Learn_Java.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class UserRequest implements Serializable {
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "isActive cannot be null")
    private Boolean isActive;

    @NotNull(message = "Person cannot be null")
    private PersonRequest person;

    public UserRequest() {
    }

    public UserRequest(String email, String password, PersonRequest person, Boolean isActive) {
        this.email = email;
        this.password = password;
        this.person = person;
        this.isActive = isActive;
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

    public PersonRequest getPerson() {
        return person;
    }

    public void setPerson(PersonRequest person) {
        this.person = person;
    }
}
