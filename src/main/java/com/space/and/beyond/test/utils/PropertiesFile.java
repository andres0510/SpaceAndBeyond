package com.space.and.beyond.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    private Properties propertiesFile;

    public PropertiesFile(String propertiesPath) {
        try (FileInputStream fis = new FileInputStream(propertiesPath)) {
            propertiesFile = new Properties();
            propertiesFile.load(fis);
        } catch (IOException e) {
            Report.reportFail(e.getMessage());
        }
    }

    public String getProperty(String key) {
        return propertiesFile.get(key).toString();
    }

}
