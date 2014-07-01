package com.sanjay.ubstest.impl.convertor;

import java.util.ArrayList;
import java.util.List;
import com.sanjay.ubstest.currency.Currency;
import com.sanjay.ubstest.currency.FXMarket;
import com.sanjay.ubstest.currency.FXStaticMarket;
import com.sanjay.ubstest.currency.UnknownCurrencyException;
import com.sanjay.ubstest.entity.TradeData;

/**
 * Created by chickpick on 29/06/14.
 */
public class StringToData implements Converter<String,TradeData>{

    private FXMarket fxMarket = new FXStaticMarket();
    @Override
    public TradeData convert(String input) throws ConverterException {

        if ( input == null ){
            throw new ConverterException("Invalid input", new IllegalArgumentException());
        }

        String tokenns[] = input.split("\t");
        if ( tokenns.length !=7 ){
            throw new ConverterException("Invalid input data", new IllegalArgumentException("Invalid input"));
        }

        TradeData dataInfo = new TradeData();
        dataInfo.setCompanyCode(tokenns[0].trim());
        dataInfo.setAccount(tokenns[1].trim());
        dataInfo.setCity(tokenns[2].trim());
        dataInfo.setCountry(tokenns[3].trim());
        dataInfo.setCreditRating(tokenns[4].trim());
        dataInfo.setCurrency(Currency.valueOf(tokenns[5].trim()));
        dataInfo.setAmount(Double.parseDouble(tokenns[6].trim()));
        try {
            dataInfo.setEuroAmount(fxMarket.exchangeToEuro(dataInfo.getCurrency(),dataInfo.getAmount()));
        } catch (UnknownCurrencyException e) {
            throw new ConverterException(e.getMessage(),e);
        }
        return dataInfo;
    }

    public List<TradeData> convert(List<String> inputList) throws ConverterException {
        List<TradeData> dataList = new ArrayList<TradeData>();
        for ( String line: inputList){
            dataList.add(convert(line));
        }

        return dataList;
    }
}
