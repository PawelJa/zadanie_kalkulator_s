package com.calculator.app.service;

import com.calculator.app.dao.CountryDAO;
import com.calculator.app.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryDAO countryDAO = new CountryDAO();

    public List<Country> getCountriesList() {
        return countryDAO.getList();
    }
}
