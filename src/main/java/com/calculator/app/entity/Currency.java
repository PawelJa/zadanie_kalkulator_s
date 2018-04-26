package com.calculator.app.entity;

public class Currency {

    private String no;
    private String effectiveDate;
    private Double bid;
    private Double ask;

    public Currency() {
    }

    public Currency(String no, String effectiveDate, Double bid, Double ask) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.bid = bid;
        this.ask = ask;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public Double getBid() {
        return bid;
    }

    public Double getAsk() {
        return ask;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
