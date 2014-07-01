package com.sanjay.ubstest.impl;

import com.sanjay.ubstest.AverageApp;
import com.sanjay.ubstest.currency.Currency;
import com.sanjay.ubstest.currency.Exchanger;
import com.sanjay.ubstest.currency.FXMarket;
import com.sanjay.ubstest.currency.UnknownCurrencyException;
import com.sanjay.ubstest.entity.AverageAppException;
import com.sanjay.ubstest.entity.EuroData;
import com.sanjay.ubstest.entity.GroupEuroData;
import com.sanjay.ubstest.entity.TradeData;
import com.sanjay.ubstest.impl.convertor.ConverterException;
import com.sanjay.ubstest.impl.convertor.StringToData;
import com.sanjay.ubstest.impl.convertor.ToEuroDataConvertor;
import com.sanjay.ubstest.impl.convertor.ToGroupEuroDataConverter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Double.parseDouble;

/**
 * Created by chickpick on 30/06/14.
 */
public class AverageAppImpl implements AverageApp {
    private StringToData stringToData = new StringToData();
   private ToEuroDataConvertor toEuroDataConvertor = new ToEuroDataConvertor();
    private ToGroupEuroDataConverter toGroupEuroDataConverter = new ToGroupEuroDataConverter();

    @Override
    public void showEuroAverage(String dataFilePath) throws AverageAppException {
        try {
            URL resourceUrl = getClass().getResource(dataFilePath);
            Path resourcePath = Paths.get(resourceUrl.toURI());
            List<String> lines = Files.readAllLines(resourcePath, Charset.defaultCharset());
            lines.remove(0);
            List<TradeData> dataList = stringToData.convert(lines);
            List<EuroData> euroDataList = toEuroDataConvertor.convert(dataList);
            GroupEuroData groupEuro = toGroupEuroDataConverter.convert(euroDataList);

            groupEuro.printAvg();

        }catch(ConverterException ex){
            throw new AverageAppException();
        } catch (IOException e) {
            throw new AverageAppException();
        } catch (URISyntaxException e) {
            throw new AverageAppException();
        } finally {
        }
    }
}
