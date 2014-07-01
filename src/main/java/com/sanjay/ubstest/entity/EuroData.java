package com.sanjay.ubstest.entity;

/**
 * Created by chickpick on 01/07/14.
 */
public class EuroData {
    final private String country;
    final private String rating;
    final private Double amount;

    public String getCountry() {
        return country;
    }

    public String getRating() {
        return rating;
    }

    public Double getAmount() {
        return amount;
    }

    public EuroData(String country, String rating, Double amount) {
        this.country = country;
        this.rating = rating;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "EuroData{" +
                "country='" + country + '\'' +
                ", rating='" + rating + '\'' +
                ", amount=" + amount +
                '}';
    }
}
