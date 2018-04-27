package com.calculator.app.service;

import com.calculator.app.dao.CurrencyDAO;
import com.calculator.app.entity.Country;
import com.calculator.app.entity.Currency;
import com.calculator.app.entity.Earning;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Service
public class EarningService {

    public Earning getEarnedMoney(Country country, double earningPerDay) throws IOException {

        int daysCounter = 22;
        Earning earning = new Earning();

        if (country.getId().equals("PL")) {
            earning.setCurency(country.getCurrency());
            earning.setDate(LocalDate.now().toString());

            double temp = (((daysCounter * earningPerDay) / (1 + (country.getTaxPercent() / 100))) - country.getOncost());
            double truncatedDouble = BigDecimal.valueOf(temp).setScale(2, RoundingMode.HALF_UP).doubleValue();
            earning.setValue(Double.valueOf(truncatedDouble));

        } else {

            CurrencyDAO currencyDAO = new CurrencyDAO(country.getCurrency());
            Currency currency = currencyDAO.getRate(country.getCurrency());
            System.out.println(country.toString());

            earning.setCurency(country.getCurrency());
            earning.setDate(currency.getEffectiveDate());
            System.out.println(daysCounter * earningPerDay);
            System.out.println(1 + (country.getTaxPercent() / 100));
            System.out.println(country.getOncost());
            double temp = (((daysCounter * (earningPerDay/1.23)) / (1 + (country.getTaxPercent() / 100))) - country.getOncost()) * currency.getBid();
            double truncatedDouble = BigDecimal.valueOf(temp).setScale(2, RoundingMode.HALF_UP).doubleValue();
            earning.setValue(Double.valueOf(truncatedDouble));
        }

        return earning;
    }
}
