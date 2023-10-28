package com.space.and.beyond.test.utils.dictionary;

public class PropertiesPath {

    private PropertiesPath(){}

    private static final String OS_SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_PATH = "src/main/resources/properties/configuration.properties";
    public static final String DEFAULT = DEFAULT_PATH.replace("/", OS_SEPARATOR);

}
