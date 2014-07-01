package com.sanjay.ubstest.currency;

/**
 * Created by chickpick on 30/06/14.
 */
public class CurrencyPair {
    private final String baseCurrency;
    private final String toCurrency;
    private final Double exchangeRate;

    public CurrencyPair(String fromCurrency, String toCurrency, Double exchangeRate) {
        this.baseCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

}
