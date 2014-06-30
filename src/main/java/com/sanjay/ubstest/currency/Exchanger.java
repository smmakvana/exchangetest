package com.sanjay.ubstest.currency;

/**
 * Created by chickpick on 30/06/14.
 */
public interface Exchanger {

    /**
     *
     * @param fromCurrency base currency
     * @param toCurrency target currency
     * @param amount amount required to exchange
     * @return exchanged amount
     * @throws UnknownCurrencyException
     */
    public Double exchange(Currency fromCurrency, Currency toCurrency, Double amount) throws UnknownCurrencyException;

    public Double exchangeToEuro(Currency fromCurrency, Double amount) throws UnknownCurrencyException;
}
