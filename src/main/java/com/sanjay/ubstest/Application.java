package com.sanjay.ubstest;

import com.sanjay.ubstest.entity.AverageAppException;
import com.sanjay.ubstest.impl.AverageAppImpl;

/**
 * Created by chickpick on 30/06/14.
 */
public class Application {
    public static void main(String[] args) throws AverageAppException {
       AverageApp app = new AverageAppImpl();
       app.showEuroAverage("/FILE.DAT");
    }
}
