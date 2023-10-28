package com.space.and.beyond.test.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static com.space.and.beyond.test.utils.dictionary.DateFormat.YYYY_MM_DD_HH_MM_SS;
import static com.space.and.beyond.test.utils.dictionary.Message.FAIL;
import static org.assertj.core.api.Assertions.fail;

public class Report {

    private static Logger log;

    private Report() { }

    public static void init(){
        try {
            String logName = String.format("log/log%s.txt", DateUtils.getCurrentDate(YYYY_MM_DD_HH_MM_SS));
            log = Logger.getLogger(logName);
            FileHandler file = new FileHandler(logName);
            SimpleFormatter formatter = new SimpleFormatter();
            file.setFormatter(formatter);
            log.addHandler(file);
        } catch (IOException e) {
            fail(String.format(FAIL, e.getMessage()));
        }
    }

    public static void reportInfo(String message) {
        log.log(Level.INFO, message);
    }

    public static void reportFail(String message) {
        log.log(Level.SEVERE, message);
        fail(String.format(FAIL, message));
    }

}