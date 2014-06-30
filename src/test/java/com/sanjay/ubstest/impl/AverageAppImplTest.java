package com.sanjay.ubstest.impl;

import com.sanjay.ubstest.AverageApp;
import com.sanjay.ubstest.entity.AverageAppException;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;

/**
 * Created by chickpick on 30/06/14.
 */
public class AverageAppImplTest {

    @Test
    public void showEuroAverage() throws AverageAppException, IOException {
        AverageApp app = new AverageAppImpl();
        app.showEuroAverage("resources/FILE.DAT");
        assertTrue(true);
    }
}
