package com.space.and.beyond.test.model.dto;

import com.space.and.beyond.test.utils.DataUtils;
import lombok.Getter;

@Getter
public class CheckoutInfo {

    private String name;
    private String email;
    private String socialSecurityNumber;
    private String phoneNumber;

    public CheckoutInfo(){
        this.name = DataUtils.getFaker().name().name();
        this.email = DataUtils.getFaker().internet().emailAddress();
        this.socialSecurityNumber = DataUtils.generateSocialSecurityNumber();
        this.phoneNumber = DataUtils.generatePhoneNumber();
    }

}
