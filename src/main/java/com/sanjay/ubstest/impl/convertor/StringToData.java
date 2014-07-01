package com.sanjay.ubstest.impl.convertor;

import com.sanjay.ubstest.entity.TradeData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chickpick on 29/06/14.
 */
public class StringToData implements Converter<String,TradeData>{
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
        dataInfo.setCurrency(tokenns[5].trim());
        dataInfo.setAmount(Double.parseDouble(tokenns[6].trim()));
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
