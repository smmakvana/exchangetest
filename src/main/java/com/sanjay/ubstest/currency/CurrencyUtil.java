package com.sanjay.ubstest.currency;
/*
 * Masabi Ltd.
 * 56 Ayres Street, London, SE1 1EU
 * http://www.masabi.com/
 *
 * Copyright (c) 2014 Masabi Ltd. All rights reserved.
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
