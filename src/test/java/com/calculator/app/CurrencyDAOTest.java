package com.calculator.app;

import com.calculator.app.dao.CurrencyDAO;
import com.calculator.app.entity.Currency;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CurrencyDAOTest {

    CurrencyDAO currencyDAO = new CurrencyDAO("chf");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate now = LocalDate.now();
    String today = now.toString();

    public CurrencyDAOTest() throws IOException {
    }


    @Test
    public void testCreatingURL() {
        String expected = "http://api.nbp.pl/api/exchangerates/rates/c/chf";
//        currencyDAO.setDate(today);
        String stringFromCurrencyDAO = currencyDAO.createUrl();
        Assert.assertEquals(expected, stringFromCurrencyDAO);
    }

    @Test
    public void testHttpStatusFromUrl() throws IOException {
        int code = getResponseCode();
        assertTrue(code == 200);
    }

//    @Test
//    public void testGetCurrencyRate() throws IOException {
//        double expected = 3.4772;
//        double gettedFromCurrencyDAO = currencyDAO.getCurrencyRate();
//        System.out.println(currencyDAO);
//        assertTrue(expected == gettedFromCurrencyDAO);
//    }

    @Test
    public void testGetRate() throws IOException {
        Currency currencyExpected = new Currency("080/C/NBP/2018", "2018-04-24", 3.4797, 3.5499);
        Currency currencyFromDao = currencyDAO.getRate("/chf/2018-04-24");
        System.out.println(currencyExpected);
        System.out.println(currencyFromDao);
        assertTrue(currencyExpected.getNo().equals(currencyFromDao.getNo()));
        assertTrue(currencyExpected.getEffectiveDate().equals(currencyFromDao.getEffectiveDate()));
        assertTrue(currencyExpected.getBid().equals(currencyFromDao.getBid()));
        assertTrue(currencyExpected.getAsk().equals(currencyFromDao.getAsk()));

    }

    public int getResponseCode() throws IOException {
        int code;
        currencyDAO.setCurrency("chf");
        URL url = new URL(currencyDAO.createUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        code = connection.getResponseCode();
        return code;
    }
}
