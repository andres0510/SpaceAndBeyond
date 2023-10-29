package com.space.and.beyond.test.utils.dictionary;

public class Path {

    private Path(){}

    private static final String OS_SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_PROPERTIES_PATH = "src/main/resources/properties/configuration.properties";
    private static final String HEALT_INSURANCE_PATH = "src/main/resources/files/HealthInsurance.pdf";
    public static final String DEFAULT_PROPERTIES = DEFAULT_PROPERTIES_PATH.replace("/", OS_SEPARATOR);
    public static final String HEALT_INSURANCE_FILE = String.format("%s/%s", System.getProperty("user.dir"), HEALT_INSURANCE_PATH.replace("/", OS_SEPARATOR));

}
