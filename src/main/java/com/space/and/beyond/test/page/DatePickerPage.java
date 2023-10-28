package com.space.and.beyond.test.page;

import com.space.and.beyond.test.factory.DriverManager;
import com.space.and.beyond.test.factory.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePickerPage extends GeneralPage {

    @FindBy(id = "years")
    private WebElement slctYear;

    @FindBy(id = "left")
    private WebElement btnLeft;

    @FindBy(id = "right")
    private WebElement btnRight;

    @FindBy(xpath = "//button[@id='right']/following-sibling::span/div/span")
    private WebElement lblMonth;

    @FindBy(xpath = "//button[text()='Ok']")
    private WebElement btnOk;

    @FindBy(xpath = "//div[@data-react-toolbox='dialog']")
    private WebElement dlgDatePicker;

    public void clickSelectYear() {
        Wait.forElementClickable(slctYear);
        slctYear.click();
    }

    public void clickOptionYear(String year) {
        Wait.forElementClickable(DriverManager.getDriver().findElement(By.id(year)));
        DriverManager.getDriver().findElement(By.id(year)).click();
    }

    public String getSelectedMonth() {
        return lblMonth.getText();
    }

    public void clickBtnPreviousMonth() {
        Wait.forElementClickable(btnLeft);
        btnLeft.click();
    }

    public void clickBtnNextMonth() {
        Wait.forElementClickable(btnRight);
        btnRight.click();
    }

    public void clickLblDay(String day) {
        String xpath = String.format("//span[text()='%s']", day);
        Wait.forElementClickable(DriverManager.getDriver().findElement(By.xpath(xpath)));
        DriverManager.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void clickBtnOk() {
        btnOk.click();
        Wait.forElementInvisible(dlgDatePicker);
    }

}
