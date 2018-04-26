package com.calculator.app.entity;

public class Earning {
    private String date;
    private String curency;
    private Double value;

    public Earning() {
    }

    public Earning(String date, String curency, Double value) {
        this.date = date;
        this.curency = curency;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurency() {
        return curency;
    }

    public void setCurency(String curency) {
        this.curency = curency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Earning{" +
                "date='" + date + '\'' +
                ", curency='" + curency + '\'' +
                ", value=" + value +
                '}';
    }
}
