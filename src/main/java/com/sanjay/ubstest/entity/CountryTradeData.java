package com.sanjay.ubstest.entity;

import java.util.HashMap;

/**
 * Hold the country trade data.
 */
public class CountryTradeData {
    private final String country;
    private Double totalPrice; // price in euro
    private int numberOfTrades;

    private HashMap<String, CreditTradeData> creditMap = new HashMap<String, CreditTradeData>();

    public CountryTradeData(final String country) {
        this.country = country;
        this.totalPrice = 0.0;
        this.numberOfTrades = 0;
    }

    public void add(String rating, Double amount){
        CreditTradeData creditTradeData = creditMap.get(rating);
        if (creditTradeData == null ){
            creditTradeData = new CreditTradeData(rating);
            creditMap.put(rating,creditTradeData);
        }
        totalPrice += amount;
        numberOfTrades++;
        creditTradeData.add(amount);

    }

    /**
     * if prices are not available then average will return as -1;
     * @return
     */
    public Double getAverage(){
        Double average = -1.0;
        if ( numberOfTrades>0){
            average = totalPrice/numberOfTrades;
        }
        return  average;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        for ( String country : creditMap.keySet()){
            CreditTradeData value = creditMap.get(country);
            sb.append(value.toString());
        }
        sb.append(String.format("=================================================\nRating[%s]  Avg: Euro %.2f\n", country, getAverage()));
        return sb.toString();
    }

    public static void main(String[] args) {
        CountryTradeData countryTradeData = new CountryTradeData("AAA");
        countryTradeData.add("A", 1.0);
        countryTradeData.add("A", 2.0);
        countryTradeData.add("A", 3.0);

        countryTradeData.add("B", 1.0);
        countryTradeData.add("B", 2.0);

        countryTradeData.add("C", 1.3);
        System.out.println(countryTradeData.toString());

    }
}
