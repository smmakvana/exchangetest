package com.sanjay.ubstest.entity;

import com.sanjay.ubstest.currency.Currency;

/**
 * Hold the each trade data.
 */
public class TradeData {

    private String companyCode;
    private String account;
    private String city;
    private String country;
    private String creditRating;
    private Currency currency;
    private Double amount;
    private Double euroAmount;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(final Currency currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TradeData{" +
                "companyCode='" + companyCode + '\'' +
                ", account='" + account + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", creditRating='" + creditRating + '\'' +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    public String getCountryOrCity() {
        return country!=null && country.trim().length()>0?country.trim().toUpperCase(): (city!=null?city:"unknown");

    }

    public Double getEuroAmount() {
        return euroAmount;
    }

    public void setEuroAmount(final Double euroAmount) {
        this.euroAmount = euroAmount;
    }
}
