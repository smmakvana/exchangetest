package com.sanjay.ubstest.currency;

/**
 * Created by chickpick on 30/06/14.
 */
public class CurrencyExchange {
    private final String fromCurrency;
    private final String toCurrency;
    private final Double exchangeRate;

    public CurrencyExchange(String fromCurrency, String toCurrency, Double exchangeRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

}
