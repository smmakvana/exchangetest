package com.sanjay.ubstest.currency;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by chickpick on 30/06/14.
 */
public class ExchangeFactoryTest extends TestCase {
    //Exchange Rates:
//        GBP -> USD  = 1.654
//        CHF -> USD  = 1.10
//        EUR -> USD  = 1.35
    @Test
    public void testGBPUSD() throws UnknownCurrencyException {
        FXMarket exchangeFactory = new FXMarket();
        Double usd = exchangeFactory.exchange(Currency.GBP, Currency.USD, 10.00);
        assertEquals(usd,16.54);
    }

    @Test
    public void testUSDGBP() throws UnknownCurrencyException {
        FXMarket exchangeFactory = new FXMarket();
        Double gbp = exchangeFactory.exchange(Currency.USD, Currency.GBP, 10.00);
        System.out.println(gbp);
        assertEquals(gbp,10/1.654);
    }
}
