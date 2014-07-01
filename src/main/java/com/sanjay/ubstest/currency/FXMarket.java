package com.sanjay.ubstest.currency;

/**
 * Foreign Exchange market API
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
