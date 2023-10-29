package com.space.and.beyond.test.page;

import com.space.and.beyond.test.factory.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends GeneralPage {

    @FindBy(xpath = "//span[text()='Name']/preceding-sibling::input")
    private WebElement txtName;

    @FindBy(xpath = "//span[text()='Email Address']/preceding-sibling::input")
    private WebElement txtEmailAddress;

    @FindBy(xpath = "//span[text()='Social Security Number']/preceding-sibling::input")
    private WebElement txtSocialSecurityNumber;

    @FindBy(xpath = "//span[text()='Phone Number']/preceding-sibling::input")
    private WebElement txtPhoneNumber;

    @FindBy(xpath = "//span[contains(text(),'Enter a valid')]")
    private WebElement msgErrorPhoneNumber;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement inputHealthInsurance;

    @FindBy(xpath = "//div[text()='Total']//strong")
    private WebElement lblTotalPrice;

    @FindBy(xpath = "//span[text()='I agree to the terms and conditions']/preceding-sibling::div")
    private WebElement radioAcceptTermsAndConditions;

    @FindBy(xpath = "//button[text()='Pay now']")
    private WebElement btnPayNow;

    public void typeName(String name) {
        txtName.sendKeys(name);
    }

    public void typeEmailAddress(String email) {
        txtEmailAddress.sendKeys(email);
    }

    public void typeSocialSecurityNumber(String socialSecurityNumber) {
        txtSocialSecurityNumber.sendKeys(socialSecurityNumber);
    }

    public void clickSocialSecurityNumber() {
        txtSocialSecurityNumber.click();
    }

    public void typePhoneNumber(String phone) {
        txtPhoneNumber.clear();
        txtPhoneNumber.sendKeys(phone);
    }

    public String getErrorMessagePhoneNumber() {
        Wait.forElementVisible(msgErrorPhoneNumber);
        return msgErrorPhoneNumber.getText();
    }

    public void enterHealthInsurance(String path) {
        inputHealthInsurance.sendKeys(path);
    }

    public String getTotalPrice() {
        return lblTotalPrice.getText();
    }

    public void clickAcceptTermsAndConditions() {
        radioAcceptTermsAndConditions.click();
    }

    public void clickBtnPayNow() {
        Wait.forElementClickable(btnPayNow);
        btnPayNow.click();
    }

}
