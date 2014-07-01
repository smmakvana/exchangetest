package com.sanjay.ubstest.impl.convertor;

import com.sanjay.ubstest.entity.TradeData;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by chickpick on 30/06/14.
 */
public class StringToDataTest {
    @Test(expected = ConverterException.class)
    public void testNullInput() throws ConverterException {
        StringToData stringToData = new StringToData();
        stringToData.convert((String) null);
    }


    @Test(expected = ConverterException.class)
    public void testInvalidInput1() throws ConverterException {
        (new StringToData()).convert("2300\t9917319\t\tUSA\tAAA+\tCHF");
    }

    @Test
    public void testOutput() throws ConverterException {
        //Company Code	Account	City	Country	Credit Rating	Currency	Amount
        //
        StringToData stringToData = new StringToData();
        TradeData dataInfo;
        dataInfo = stringToData.convert("2300\t9917319\t\tUSA\tAAA+\tCHF\t9223372036854775809.456");

        assertEquals("2300",dataInfo.getCompanyCode());
        assertEquals("9917319",dataInfo.getAccount());
        assertEquals("USA",dataInfo.getCountry());
        assertEquals("AAA+",dataInfo.getCreditRating());
        assertEquals("",dataInfo.getCity());
        assertEquals("CHF",dataInfo.getCurrency());
        assertEquals("9223372036854775809.456",dataInfo.getAmount());
    }
}
