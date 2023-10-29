package com.space.and.beyond.test.steps.gui;

import com.space.and.beyond.test.factory.DriverManager;
import com.space.and.beyond.test.utils.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class GeneralStepDefinition {

    private GeneralStepDefinition(){}

    @Before
    public static void setUp(){
        Report.init();
        DriverManager.init();
    }

    @After
    public static void tearDown(){
        DriverManager.finish();
    }

}
