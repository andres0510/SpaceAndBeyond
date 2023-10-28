package com.space.and.beyond.test.factory;

import com.space.and.beyond.test.utils.Report;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.space.and.beyond.test.utils.dictionary.Message.TIMEOUT;

public class Wait {

    private static WebDriverWait webDriverWait;
    private static final int DEFAULT = 30;

    private Wait(){}

    public static void init(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT));
    }

    public static void forElementClickable(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            Report.reportFail(String.format(TIMEOUT, e.getMessage()));
        }
    }

}
