package com.sanjay.ubstest.impl;

import com.sanjay.ubstest.AverageApp;
import com.sanjay.ubstest.currency.Currency;
import com.sanjay.ubstest.currency.Exchanger;
import com.sanjay.ubstest.currency.FXMarket;
import com.sanjay.ubstest.currency.UnknownCurrencyException;
import com.sanjay.ubstest.entity.AverageAppException;
import com.sanjay.ubstest.entity.DataInfo;
import com.sanjay.ubstest.impl.convertor.ConverterException;
import com.sanjay.ubstest.impl.convertor.StringToData;

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
   private Exchanger exchanger = new FXMarket();

    @Override
    public void showEuroAverage(String dataFilePath) throws AverageAppException {
        try {
            URL resourceUrl = getClass().getResource(dataFilePath);
            Path resourcePath = Paths.get(resourceUrl.toURI());
            List<String> lines = Files.readAllLines(resourcePath, Charset.defaultCharset());
            List<DataInfo> dataList = stringToData.convert(lines);
            dataList.remove(0);
            for (DataInfo line : dataList) {
                System.out.print(line.getCurrency() + " " + line.getAmount() + " ");
                Double amount = parseDouble(line.getAmount());
                Double euro = exchanger.exchangeToEuro(Currency.valueOf(line.getCurrency()),  amount);
                    System.out.println("-> Euro : " + euro);
            }
        }catch(ConverterException ex){
            throw new AverageAppException();
        } catch (IOException e) {
            throw new AverageAppException();
        } catch (URISyntaxException e) {
            throw new AverageAppException();
        } catch (UnknownCurrencyException e) {
            throw new AverageAppException();
        } finally {
        }
    }
}
