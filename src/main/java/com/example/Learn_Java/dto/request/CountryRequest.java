package com.example.Learn_Java.dto.request;
import jakarta.validation.constraints.NotBlank;

public class CountryRequest {
    @NotBlank(message = "name not blank")
    private String name;

    @NotBlank(message = "code not blank")
    private String code;

    @NotBlank(message = "description not blank")
    private String description;

    public CountryRequest() {
    }

    public CountryRequest(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}