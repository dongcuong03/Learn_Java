package com.example.Learn_Java.controller;

import com.example.Learn_Java.dto.request.CountryRequest;
import com.example.Learn_Java.dto.response.ResponseData;
import com.example.Learn_Java.dto.response.ResponseError;
import com.example.Learn_Java.service.CountryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country")
@Validated
@Slf4j
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/")
    public ResponseData<?> addCountry(@Valid @RequestBody CountryRequest countryRequest) {
        try {
            long id = countryService.create(countryRequest);
            return new ResponseData<>(HttpStatus.CREATED.value(), "Country add success", id);
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add country fail");
        }
    }
    @GetMapping("/getAllCountry")
    public ResponseData<?> getAllCountry() {
        try {
            return new ResponseData<>(HttpStatus.OK.value(), "Get all country", countryService.getAllCountries());
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
    @GetMapping("getCountry/{id}")
    public ResponseData<?> getCountry(@PathVariable @Min(value = 1, message = "Id must be greater than 0") long id) {

        try {
            return new ResponseData<>(HttpStatus.OK.value(), "Get country by id", countryService.getById(id));
        } catch (Exception e) {

            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseData<?> updateCountry(@PathVariable @Min(1) long id, @Valid @RequestBody CountryRequest countryRequest) {
        try {
            countryService.update(id, countryRequest);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "Country update success");
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Update country fail");
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseData<?> deleteCountry(@PathVariable @Min(value = 1, message = "Id must be greater than 0") long id) {
        try {
            countryService.deleteById(id);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Delete country success");
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Delete country fail");
        }
    }

}
