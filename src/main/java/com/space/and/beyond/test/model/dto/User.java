package com.space.and.beyond.test.model.dto;

import com.space.and.beyond.test.utils.DataUtils;
import lombok.Getter;

@Getter
public class User {

    private String username;
    private String password;

    public User() {
        this.username = DataUtils.getFaker().internet().emailAddress();
        this.password = DataUtils.getFaker().internet().password();
    }

}
