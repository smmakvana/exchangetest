package com.sanjay.ubstest.currency;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulated Foregin Exchange Market.
 */
public class FXMarket implements Exchanger {
    private Map<String,CurrencyExchange> exchangeMap = new HashMap<String, CurrencyExchange>();

    public FXMarket(){
        loadStaticMarket();
    }

    private void loadStaticMarket() {
        addMarket(Currency.GBP, Currency.USD, 1.654);
        addMarket(Currency.CHF, Currency.USD, 1.10);
        addMarket(Currency.EUR, Currency.USD, 1.35);
    }

    private void addMarket(Currency fromCurrency, Currency toCurrency, Double exchangeRate) {
        CurrencyExchange currencyExchange = new CurrencyExchange(fromCurrency.toString(), toCurrency.toString(), exchangeRate);
        exchangeMap.put(getCurrencyPairKey(fromCurrency, toCurrency),currencyExchange);

        currencyExchange = new CurrencyExchange(toCurrency.toString(), fromCurrency.toString(), 1.0/exchangeRate);
        exchangeMap.put(getCurrencyPairKey(toCurrency, fromCurrency),currencyExchange);
    }

    private String getCurrencyPairKey(Currency fromCurrency, Currency toCurrency) {
        return fromCurrency + "_" + toCurrency;
    }

    @Override
    public Double exchange(Currency fromCurrency, Currency toCurrency, Double amount) throws UnknownCurrencyException {
        CurrencyExchange currencyExchange = exchangeMap.get(getCurrencyPairKey(fromCurrency, toCurrency));
        if ( currencyExchange == null){
            throw  new UnknownCurrencyException("Unknown currency");
        }
        return currencyExchange.getExchangeRate() * amount;
    }

    @Override
    public Double exchangeToEuro(Currency fromCurrency, Double amount) throws UnknownCurrencyException {
        Double usd = exchange(fromCurrency, Currency.USD, amount);
        return exchange(Currency.USD, Currency.EUR,usd);
    }
}
