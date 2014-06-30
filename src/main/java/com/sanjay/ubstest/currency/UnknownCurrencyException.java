package com.sanjay.ubstest.currency;

/**
 * Created by chickpick on 30/06/14.
 */
public class UnknownCurrencyException extends Exception {
    public UnknownCurrencyException(String message) {
        super(message);
    }
}
