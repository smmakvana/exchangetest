package com.sanjay.ubstest;

/**
 * Created by chickpick on 29/06/14.
 */
public class DataInfo {

    //Company Code	Account	City	Country	Credit Rating	Currency	Amount

    //Company Code	Account	City	Country	Credit Rating	Currency	Amount
    //2300	9917319		USA	AAA+	CHF	9223372036854775809.456

    private String companyCode;
    private String account;
    private String city;
    private String country;
    private String creditRating;
    private String currency;
    private String amount;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
