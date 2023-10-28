package com.space.and.beyond.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends GeneralPage {

    @FindBy(xpath = "//span[contains(text(),'Username')]/parent::div/input")
    private WebElement txtUsername;

    @FindBy(xpath = "//span[contains(text(),'Password')]/parent::div/input")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    public void typeUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void typePassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void pressLoginButton() {
        btnLogin.click();
    }

}
