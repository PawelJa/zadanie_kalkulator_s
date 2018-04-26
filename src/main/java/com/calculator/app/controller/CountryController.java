package com.calculator.app.controller;

import com.calculator.app.dao.CountryDAO;
import com.calculator.app.entity.Country;
import com.calculator.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public List<Country> getCountries() {
        return countryService.getCountriesList();
    }
}
