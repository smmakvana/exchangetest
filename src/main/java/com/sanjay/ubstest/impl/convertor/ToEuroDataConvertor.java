package com.sanjay.ubstest.impl.convertor;

import com.sanjay.ubstest.currency.Currency;
import com.sanjay.ubstest.currency.Exchanger;
import com.sanjay.ubstest.currency.FXMarket;
import com.sanjay.ubstest.currency.UnknownCurrencyException;
import com.sanjay.ubstest.entity.EuroData;
import com.sanjay.ubstest.entity.TradeData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chickpick on 01/07/14.
 */
public class ToEuroDataConvertor implements Converter<TradeData, EuroData> {

    private final Exchanger exchanger = new FXMarket();


    @Override
    public EuroData convert(TradeData input) throws ConverterException {

        String countryOrCity = input.getCountry();
        if ( countryOrCity==null || countryOrCity.trim().isEmpty()){
            countryOrCity = input.getCity();
        }

        Double euro = null;
        try {
            euro = exchanger.exchangeToEuro(Currency.valueOf(input.getCurrency()),  input.getAmount());
        } catch (UnknownCurrencyException e) {
            new ConverterException(e.getMessage(),e);
        }
        return new EuroData(countryOrCity,input.getCreditRating(),euro);
    }

    public List<EuroData> convert(List<TradeData> inputList) throws ConverterException {
        List<EuroData> dataList = new ArrayList<EuroData>();
        for ( TradeData tradeData: inputList){
            dataList.add(convert(tradeData));
        }
        return dataList;
    }
}
