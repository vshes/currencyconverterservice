package com.fidelity.am.model;


public class Country  {

    private  String name;
    private  String currency;
    private  String countryCode;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", COUNTRY_CODE='" + countryCode + '\'' +
                '}';
    }

    public  Country(){

    }
    public Country(String code, String name, String currency) {
        this.countryCode =code;
        this.name=name;
        this.currency=currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
