package com.calculator.app.dao;

import com.calculator.app.entity.Currency;
import com.google.gson.Gson;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

@Component
public class CurrencyDAO {

    final private String jsonUrlPart1 = "http://api.nbp.pl/api/exchangerates/rates/c/";
    private String currency;


    public CurrencyDAO() {
    }

    public CurrencyDAO (String currency) {
        this.currency = currency;
    }

    public String getJsonUrlPart1() {
        return jsonUrlPart1;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String createUrl() {
        String url = jsonUrlPart1 + this.currency;
        return url;
    }


    public Currency getRate(String currency) throws IOException {
        this.currency = currency;
        URL url = new URL(createUrl());
        Currency currency1 = new Currency();
        Gson gson = new Gson();
        try (InputStream is = url.openStream();
             JsonReader jsonReader = Json.createReader((is))) {

            JsonObject object = jsonReader.readObject();
            JsonArray results = object.getJsonArray("rates");
            System.out.println(results.toString());
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                currency1 = gson.fromJson(result.toString(), Currency.class);
            }
        }
        return currency1;
    }

    @Override
    public String toString() {
        return "CurrencyDAO{" +
                "jsonUrlPart1='" + jsonUrlPart1 + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
