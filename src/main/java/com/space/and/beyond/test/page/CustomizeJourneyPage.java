package com.space.and.beyond.test.page;

import com.space.and.beyond.test.factory.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Date;
import java.util.List;

public class CustomizeJourneyPage extends GeneralPage {

    @FindBy(xpath = "//label[text()='Departing']/parent::div")
    private WebElement pckrDeparting;

    @FindBy(xpath = "//label[text()='Returning']/parent::div")
    WebElement pckrReturning;

    @FindBy(xpath = "//input[@value='Adults (18+)']")
    private WebElement slctAdults;

    @FindBy(xpath = "//li[text()='Adults (18+)']/parent::ul")
    private WebElement optBoxAdults;

    @FindBy(xpath = "//li[text()='Adults (18+)']/following-sibling::li")
    private List<WebElement> optAdults;

    @FindBy(xpath = "//input[@value='Children (0-7)']")
    private WebElement slctChildren;

    @FindBy(xpath = "//li[text()='Children (0-7)']/parent::ul")
    private WebElement optBoxChildren;

    @FindBy(xpath = "//li[text()='Children (0-7)']/following-sibling::li")
    private List<WebElement> optChildren;

    public void selectDepartingDate(Date departingDate) {
        pckrDeparting.click();
        DriverManager.selectDate(departingDate);
    }

    public void selectReturningDate(Date returningDate) {
        pckrReturning.click();
        DriverManager.selectDate(returningDate);
    }

    public String selectAdults() {
        return DriverManager.selectRandomOption(slctAdults, optBoxAdults, optAdults);
    }

    public String selectChildren() {
        return DriverManager.selectRandomOption(slctChildren, optBoxChildren, optChildren);
    }

}
