package com.sanjay.ubstest.currency;

import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by chickpick on 30/06/14.
 */
public class ExchangeFactoryTest extends TestCase {
    //Exchange Rates:
//        GBP -> USD  = 1.654
//        CHF -> USD  = 1.10
//        EUR -> USD  = 1.35
    @Test
    public void testGBP() throws UnknownCurrencyException {
        FXStaticMarket exchangeFactory = new FXStaticMarket();
        Double euro = exchangeFactory.exchangeToEuro(Currency.GBP, 10.00);
        System.out.println(euro);
        assertEquals(euro,16.54);
    }

    @Test
    public void testUSD() throws UnknownCurrencyException {
        FXStaticMarket exchangeFactory = new FXStaticMarket();
        Double euro = exchangeFactory.exchangeToEuro(Currency.USD, 10.00);
        System.out.println(euro);
        assertEquals(euro,10/1.654);
    }
}
