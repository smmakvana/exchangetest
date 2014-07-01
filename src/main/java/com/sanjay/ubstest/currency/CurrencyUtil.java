package com.sanjay.ubstest.currency;

/**
 * Calculate the currency pair key
 */
public class CurrencyUtil {

    /**
     *
     * @param fromCurrency Currency from currency
     * @param toCurrency Currench to currency
     * @return String combine two currency and make unique pair currency key.
     */
    public static String getCurrencyPairKey(Currency fromCurrency, Currency toCurrency) {
        return fromCurrency.toString() + "_" + toCurrency.toString();
    }

}
