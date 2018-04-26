package com.calculator.app.service;

import com.calculator.app.dao.CurrencyDAO;
import com.calculator.app.entity.Country;
import com.calculator.app.entity.Currency;
import com.calculator.app.entity.Earning;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EarningService {

    public Earning getEarnedMoney(Country country, double earningPerDay) throws IOException {
        int daysCounter = 22;
        Earning earning = new Earning();
        CurrencyDAO currencyDAO = new CurrencyDAO(country.getCurrency());
        Currency currency = currencyDAO.getRate(country.getCurrency());
        System.out.println(country.toString());

        earning.setCurency(country.getCurrency());
        earning.setDate(currency.getEffectiveDate());
        System.out.println(daysCounter*earningPerDay);
        System.out.println(1+ (country.getTaxPercent()/100));
        System.out.println(country.getOncost());
        earning.setValue( (((daysCounter*earningPerDay) / (1 + (country.getTaxPercent()/100))) - country.getOncost()) * currency.getBid() );

        return earning;
    }
}
