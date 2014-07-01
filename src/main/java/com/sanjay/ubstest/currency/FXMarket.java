package com.sanjay.ubstest.currency;

/**
 * Created by chickpick on 30/06/14.
 */
public interface FXMarket {

    /**
     *
     * @param fromCurrency base currency
     * @param amount amount required to exchange
     * @return exchanged amount in Euro
     * @throws UnknownCurrencyException
     */
    public Double exchangeToEuro(Currency fromCurrency, Double amount) throws UnknownCurrencyException;
}
