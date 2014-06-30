package com.sanjay.ubstest.impl.convertor;

import com.sanjay.ubstest.entity.DataInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chickpick on 29/06/14.
 */
public class StringToData implements Converter<String,DataInfo>{
    @Override
    public DataInfo convert(String input) throws ConverterException {

        if ( input == null ){
            throw new ConverterException("Invalid input", new IllegalArgumentException());
        }

        String tokenns[] = input.split("\t");
        if ( tokenns.length !=7 ){
            throw new ConverterException("Invalid input data", new IllegalArgumentException("Invalid input"));
        }

        DataInfo dataInfo = new DataInfo();
        dataInfo.setCompanyCode(tokenns[0].trim());
        dataInfo.setAccount(tokenns[1].trim());
        dataInfo.setCity(tokenns[2].trim());
        dataInfo.setCountry(tokenns[3].trim());
        dataInfo.setCreditRating(tokenns[4].trim());
        dataInfo.setCurrency(tokenns[5].trim());
        dataInfo.setAmount(tokenns[6].trim());
        return dataInfo;
    }

    @Override
    public List<DataInfo> convert(List<String> inputList) throws ConverterException {
        List<DataInfo> dataList = new ArrayList<DataInfo>();
        for ( String line: inputList){
            dataList.add(convert(line));
        }

        return dataList;
    }
}
