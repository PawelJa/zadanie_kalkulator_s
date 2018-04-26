package com.calculator.app;

import com.calculator.app.dao.CurrencyDAO;
import com.calculator.app.entity.Country;
import com.calculator.app.entity.Currency;
import com.calculator.app.entity.Earning;
import com.calculator.app.service.EarningService;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class EarningServiceTest {

    Country country = new Country("DE", "Germany", 800, 20, "eur/2018-04-24");
    EarningService earningService = new EarningService();
    CurrencyDAO currencyDAO = new CurrencyDAO("eur");

    public EarningServiceTest() throws IOException {
    }

    @Test
    public void testGetEarnedMoney() throws IOException {
        Earning earningExpected = new Earning("2018-04-24", "eur/2018-04-24", 42383.04);
        Earning earningFromService = earningService.getEarnedMoney(country, 600);
        System.out.println(earningExpected.toString());
        System.out.println(earningFromService.toString());
        Assert.assertTrue(earningExpected.getDate().equals(earningFromService.getDate()));
        Assert.assertTrue(earningExpected.getCurency().equals(earningFromService.getCurency()));
        Assert.assertTrue(earningExpected.getValue().equals(earningFromService.getValue()));
    }
}
