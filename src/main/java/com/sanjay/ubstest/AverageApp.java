package com.sanjay.ubstest;

import com.sanjay.ubstest.entity.AverageAppException;

import java.io.IOException;

/**
 * Created by chickpick on 30/06/14.
 */
public interface AverageApp {
     void showEuroAverage(String dataFilePath) throws AverageAppException;

}
