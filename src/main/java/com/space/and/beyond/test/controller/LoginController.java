package com.space.and.beyond.test.controller;

import com.space.and.beyond.test.page.LoginPage;
import com.space.and.beyond.test.utils.Report;
import static com.space.and.beyond.test.utils.dictionary.Message.SUCCESS;

public class LoginController {

    private LoginController() {}

    public static void logIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("testingLogin");
        loginPage.typePassword("testingPassword");
        loginPage.pressLoginButton();
        Report.reportInfo(String.format(SUCCESS, "Login done"));
    }

}
