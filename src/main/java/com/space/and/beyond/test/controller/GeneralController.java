package com.space.and.beyond.test.controller;

import com.space.and.beyond.test.utils.PropertiesFile;
import com.space.and.beyond.test.utils.Report;
import com.space.and.beyond.test.factory.DriverManager;
import static com.space.and.beyond.test.utils.dictionary.Path.DEFAULT_PROPERTIES;
import static com.space.and.beyond.test.utils.dictionary.Message.SUCCESS;

public class GeneralController {

    private GeneralController(){}

    public static void openApp() {
        PropertiesFile propertiesFile = new PropertiesFile(DEFAULT_PROPERTIES);
        String appUrl = propertiesFile.getProperty("app.url");
        DriverManager.openURL(appUrl);
        Report.reportInfo(String.format(SUCCESS, "Open App"));
    }

}