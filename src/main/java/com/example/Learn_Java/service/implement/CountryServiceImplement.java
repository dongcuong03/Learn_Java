package com.example.Learn_Java.service.implement;

import com.example.Learn_Java.domain.Country;
import com.example.Learn_Java.dto.request.CountryRequest;
import com.example.Learn_Java.dto.response.CountryResponse;
import com.example.Learn_Java.exception.ResourceNotFoundException;
import com.example.Learn_Java.repository.CountryRepository;
import com.example.Learn_Java.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImplement implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryResponse> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        List<CountryResponse> countryResponses = new ArrayList<>();

        for (Country country : countries) {
            countryResponses.add(toCountryResponse(country));
        }

        return countryResponses;
    }

    @Override
    public long create(CountryRequest countryRequest) {
        Country country = toCountryEntity(countryRequest);
        countryRepository.save(country);
        return country.getId();
    }

    @Override
    public long update(long id, CountryRequest countryRequest) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        country.setName(countryRequest.getName());
        country.setCode(countryRequest.getCode());
        country.setDescription(countryRequest.getDescription());
        countryRepository.save(country);
        return country.getId();
    }

    @Override
    public CountryResponse getById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        return toCountryResponse(country);
    }

    @Override
    public void deleteById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        countryRepository.delete(country);
    }

    private Country toCountryEntity(CountryRequest countryRequest) {
        Country country = new Country();
        country.setName(countryRequest.getName());
        country.setCode(countryRequest.getCode());
        country.setDescription(countryRequest.getDescription());
        return country;
    }

    private CountryResponse toCountryResponse(Country country) {
        CountryResponse response = new CountryResponse();
        response.setId(country.getId());
        response.setName(country.getName());
        response.setCode(country.getCode());
        response.setDescription(country.getDescription());
        return response;
    }
}
