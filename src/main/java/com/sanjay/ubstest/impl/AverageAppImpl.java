package com.sanjay.ubstest.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.sanjay.ubstest.AverageApp;
import com.sanjay.ubstest.entity.AverageAppException;
import com.sanjay.ubstest.entity.TradeData;
import com.sanjay.ubstest.entity.WorldTradeData;
import com.sanjay.ubstest.impl.convertor.ConverterException;
import com.sanjay.ubstest.impl.convertor.StringToData;

/**
 * Created by chickpick on 30/06/14.
 */
public class AverageAppImpl implements AverageApp {
    private StringToData stringToData = new StringToData();

    @Override
    public void showEuroAverage(String dataFilePath) throws AverageAppException {
        try {
            URL resourceUrl = getClass().getResource(dataFilePath);
            Path resourcePath = Paths.get(resourceUrl.toURI());
            List<String> lines = Files.readAllLines(resourcePath, Charset.defaultCharset());
            lines.remove(0);
            List<TradeData> dataList = stringToData.convert(lines);

            WorldTradeData worldTradeData = new WorldTradeData();
            for (TradeData t : dataList ){
                worldTradeData.add(t.getCountryOrCity(), t.getCreditRating(), t.getEuroAmount());
            }
            System.out.println(worldTradeData.toString());

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
