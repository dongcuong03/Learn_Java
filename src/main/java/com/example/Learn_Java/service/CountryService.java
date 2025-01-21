package com.example.Learn_Java.service;

import com.example.Learn_Java.dto.request.CountryRequest;
import com.example.Learn_Java.dto.response.CountryResponse;

import java.util.List;

public interface CountryService {
    List<CountryResponse> getAllCountries();
    long create(CountryRequest countryRequest);
    long update(long id, CountryRequest countryRequest);
    CountryResponse getById(Long id);
    void deleteById(Long id);
}
