package com.space.and.beyond.test.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    @Getter
    private static WebDriver driver;

    private DriverManager(){}

    //----------------------------------------------------------------------------------------------------------------->
    //---------- INIT & FINISH ---------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        Wait.init(driver);
    }

    public static void finish() {
        driver.close();
        driver.quit();
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static void openURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

}
