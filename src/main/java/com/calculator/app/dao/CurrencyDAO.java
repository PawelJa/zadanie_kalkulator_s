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
//    private String date;
    private String currency;
//    private double currencyRate;

    public CurrencyDAO (String currency) throws IOException {
        this.currency = currency;
//        setCurrencyRate();
    }

    public String getJsonUrlPart1() {
        return jsonUrlPart1;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

//    public double getCurrencyRate() {
//        return currencyRate;
//    }


    public String createUrl() {
        String url = jsonUrlPart1 + this.currency;
        return url;
    }

//    public void setCurrencyRate() throws IOException {
//        LocalDate localDate = LocalDate.now();
//        this.date = localDate.toString();
//        int code = getResponseCode(this.date);
//        int i = 0;
//        LocalDate dateToCheck = null;
//        while (code != 200 || i == 30) {
//            i++;
//            dateToCheck = localDate.minusDays(i);
//            code = getResponseCode(dateToCheck.toString());
//        }
//        if (code == 200) {
//            this.date = dateToCheck.toString();
//        }
//        URL url = new URL(createUrl());
//
//        try (InputStream is = url.openStream();
//             JsonReader jsonReader = Json.createReader(is)) {
//
//            JsonObject object = jsonReader.readObject();
//            JsonArray results = object.getJsonArray("rates");
//            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
//                this.currencyRate = Double.valueOf(result.get("bid").toString());
//            }
//        }
//    }

//    private int getResponseCode(String date) throws IOException {
//        int code;
//        this.date = date;
//        URL url = new URL(createUrl());
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.connect();
//        code = connection.getResponseCode();
//        return code;
//    }

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
