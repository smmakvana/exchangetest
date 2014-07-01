package com.sanjay.ubstest.currency;

import static com.sanjay.ubstest.currency.CurrencyUtil.getCurrencyPairKey;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulated Foreign Exchange Market.
 */
public class FXStaticMarket implements FXMarket {
    private Map<String,CurrencyPair> exchangeMap = new HashMap<String, CurrencyPair>();

    public FXStaticMarket(){
        loadStaticMarket();
    }

    private void loadStaticMarket() {
        addMarket(Currency.GBP, Currency.USD, 1.654);
        addMarket(Currency.CHF, Currency.USD, 1.10);
        addMarket(Currency.EUR, Currency.USD, 1.35);
    }

    private void addMarket(Currency fromCurrency, Currency toCurrency, Double exchangeRate) {
        CurrencyPair currencyPair = new CurrencyPair(fromCurrency.toString(), toCurrency.toString(), exchangeRate);
        exchangeMap.put(getCurrencyPairKey(fromCurrency, toCurrency), currencyPair);

        currencyPair = new CurrencyPair(toCurrency.toString(), fromCurrency.toString(), 1.0/exchangeRate);
        exchangeMap.put(getCurrencyPairKey(toCurrency, fromCurrency), currencyPair);
    }

    private Double exchange(Currency fromCurrency, Currency toCurrency, Double amount) throws UnknownCurrencyException {
        CurrencyPair currencyPair = exchangeMap.get(getCurrencyPairKey(fromCurrency, toCurrency));
        if ( currencyPair == null){
            throw  new UnknownCurrencyException("Unknown currency");
        }
        return currencyPair.getExchangeRate() * amount;
    }

    @Override
    public Double exchangeToEuro(Currency fromCurrency, Double amount) throws UnknownCurrencyException {
        Double usd = exchange(fromCurrency, Currency.USD, amount);// we know that all the currency in  static market has is pair with USD.
        return exchange(Currency.USD, Currency.EUR,usd);
    }
}
