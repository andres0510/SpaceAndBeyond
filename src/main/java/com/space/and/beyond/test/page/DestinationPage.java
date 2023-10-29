package com.space.and.beyond.test.page;

import com.space.and.beyond.test.factory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DestinationPage extends GeneralPage{

    @FindBy(xpath = "//input[@value='Launch']")
    private WebElement slctLaunch;

    @FindBy(xpath = "//li[text()='Launch']/parent::ul")
    private WebElement optBoxLaunch;

    @FindBy(xpath = "//li[text()='Launch']/following-sibling::li")
    private List<WebElement> optLaunch;

    @FindBy(xpath = "//input[@value='Planet color']")
    private WebElement slctPlanetColor;

    @FindBy(xpath = "//li[text()='Planet color']/parent::ul")
    private WebElement optBoxPlanetColor;

    @FindBy(xpath = "//li[text()='Planet color']/following-sibling::li")
    private List<WebElement> optPlanetColor;

    @FindBy(xpath = "//div[@data-react-toolbox='card']")
    private List<WebElement> lstDestinantions;

    public void selectLaunch() {
        DriverManager.selectRandomOption(slctLaunch, optBoxLaunch, optLaunch);
    }

    public void selectPlanetColor() {
        DriverManager.selectRandomOption(slctPlanetColor, optBoxPlanetColor, optPlanetColor);
    }

    public int getDestinationsCount() {
        return lstDestinantions.size();
    }

    public String getDestinationPrice(int index) {
        final String RELATIVE_XPATH = "//span[contains(text(),'$')]";
        return lstDestinantions.get(index).findElement(By.xpath(RELATIVE_XPATH)).getText();
    }

    public void clickBtnBook(int index) {
        final String RELATIVE_XPATH = "//button[text()='Book']";
        lstDestinantions.get(index).findElement(By.xpath(RELATIVE_XPATH)).click();
    }

}
