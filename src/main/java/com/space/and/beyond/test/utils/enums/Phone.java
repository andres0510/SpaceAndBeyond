package com.space.and.beyond.test.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Phone {

    COLOMBIA("CO", "57", new String[]{"0", "1", "3"}),
    SPAIN("ES", "34", new String[]{"5", "6", "7", "8", "9"});

    private final String countryCode;
    private final String phoneCode;
    private final String[] initialDigits;

}
