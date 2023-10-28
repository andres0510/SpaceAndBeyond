package com.space.and.beyond.test.utils;

import com.github.javafaker.Faker;
import lombok.Getter;

public class DataUtils {

    @Getter
    private static final Faker faker = new Faker();

    public static String generatePhoneNumber() {
        final String FORMAT = "+%s %s";
        return String.format(FORMAT, faker.number().digits(2), faker.number().digits(10));
    }

    public static String generateSocialSecurityNumber(){
        final String FORMAT = "%s-%s-%s";
        return String.format(FORMAT, faker.number().digits(3), faker.number().digits(2), faker.number().digits(4));
    }

}
