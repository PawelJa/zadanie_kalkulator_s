package com.calculator.app;

import com.calculator.app.dao.CountryDAO;
import com.calculator.app.entity.Country;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertArrayEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOTest {

    private CountryDAO countryDAO = new CountryDAO();
    private File dataFile = countryDAO.dataFileForTests;

    private Object[] getArrayToTestListOfCountries() {
        Object[] listExpected = new Object[3];
        listExpected[0] = new Country("UK", "United Kingdom", 600, 25, "GBP");
        listExpected[1] = new Country("DE", "Germany", 800, 20, "EUR");
        listExpected[2] = new Country("PL", "Poland", 1200, 19, "PLN");
        return listExpected;
    }

    @Test
    public void testFileExist() {
        boolean fileExists = dataFile.exists();
        boolean fileExistExpected = true;
        assertTrue("File exist!", fileExists==fileExistExpected);
    }

    @Test
    public void testFileIsReadable() {
        boolean fileReadableExpected = true;
        boolean fileReadable = false;
        if (dataFile.canRead()) {
            fileReadable = true;
        }
        assertTrue("File is null", fileReadableExpected == fileReadable);
    }

    @Test
    public void testFileIsNotEmpty() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dataFile));
        boolean isNotEmpty = false;
        boolean isNotEmptyExpected = true;
        if (br.readLine() != null) {
            isNotEmpty = true;
        }
        assertTrue("File is empty", isNotEmptyExpected == isNotEmpty);
    }

    @Test
    public void testCreateList() {
        Object[] listFromCountryDAO = countryDAO.createList().toArray();
        Assert.assertNotNull(listFromCountryDAO);
        assertArrayEquals(getArrayToTestListOfCountries(), listFromCountryDAO);
    }

    @Test
    public void testGetList() {
        Object[] listFromCountryDAO = countryDAO.getList().toArray();
        assertArrayEquals(getArrayToTestListOfCountries(),listFromCountryDAO);
    }

    @Test
    public void testFindOne() {
        Country countryExpected = new Country("UK", "United Kingdom", 600, 25, "GBP");
        Country countryFromCountryDao = countryDAO.findOne("UK");
        Assert.assertTrue(countryExpected.getId().equals(countryFromCountryDao.getId()));
        Assert.assertTrue(countryExpected.getFullName().equals(countryFromCountryDao.getFullName()));
        Assert.assertTrue(countryExpected.getOncost() == countryFromCountryDao.getOncost());
        Assert.assertTrue(countryExpected.getTaxPercent() == countryFromCountryDao.getTaxPercent());
        Assert.assertTrue(countryExpected.getCurrency().equals(countryFromCountryDao.getCurrency()));
    }

}
