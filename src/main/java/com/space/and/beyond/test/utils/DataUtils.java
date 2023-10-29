package com.space.and.beyond.test.utils;

import com.github.javafaker.Faker;
import lombok.Getter;

import static com.space.and.beyond.test.utils.enums.Phone.*;
import static com.space.and.beyond.test.utils.dictionary.Message.FAIL;

public class DataUtils {

    @Getter
    private static final Faker faker = new Faker();

    public static String generatePhoneNumber() {
        return faker.number().digits(8);
    }

    public static String generateSocialSecurityNumber(){
        final String FORMAT = "%s-%s-%s";
        return String.format(FORMAT, faker.number().digits(3), faker.number().digits(2), faker.number().digits(4));
    }

    public static double getPriceAsDouble(String price) {
        price = price.replace("$", "");
        price = price.replace(",", "");
        price = price.trim();
        return Double.parseDouble(price);
    }

    public static String getCountryCode(String message) {
        String phoneCode = "";
        if (message.contains(COLOMBIA.getCountryCode())) {
            phoneCode = COLOMBIA.getPhoneCode();
        } else if (message.contains(SPAIN.getCountryCode())) {
            phoneCode = SPAIN.getPhoneCode();
        } else {
            Report.reportFail(String.format(FAIL, "Phone code not defined for current country"));
        }
        return phoneCode;
    }

    public static String getFirstDigitForPhone(String message) {
        String [] digits = new String[]{};
        if (message.contains(COLOMBIA.getCountryCode())) {
            digits = COLOMBIA.getInitialDigits();
        } else if (message.contains(SPAIN.getCountryCode())) {
            digits = SPAIN.getInitialDigits();
        } else {
            Report.reportFail(String.format(FAIL, "Initial digits not defined for current country"));
        }
        return digits[faker.number().numberBetween(0, digits.length-1)];
    }

}
