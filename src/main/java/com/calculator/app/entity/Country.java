package com.calculator.app.entity;

public class Country {

    private String id;
    private String fullName;
    private int oncost;
    private double taxPercent;
    private String currency;

    public Country() {
    }

    public Country(String id, String fullname, int oncost, double taxPercent, String currency) {
        this.id = id;
        this.fullName = fullname;
        this.oncost = oncost;
        this.taxPercent = taxPercent;
        this.currency = currency;
    }

    public boolean equals(Object obj){
        Country country = (Country) obj;
        boolean status = false;
        if(this.id.equalsIgnoreCase(country.id)
                && this.fullName.equalsIgnoreCase(country.fullName)
                && this.oncost == country.oncost
                && this.taxPercent == country.taxPercent
                && this.currency.equalsIgnoreCase(country.currency)){
            status = true;
        }
        return status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public int getOncost() {
        return oncost;
    }

    public void setOncost(int oncost) {
        this.oncost = oncost;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", oncost=" + oncost +
                ", taxPercent=" + taxPercent +
                ", currency='" + currency + '\'' +
                '}';
    }
}
