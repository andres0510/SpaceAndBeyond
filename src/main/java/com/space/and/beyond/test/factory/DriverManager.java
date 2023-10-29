package com.space.and.beyond.test.factory;

import com.space.and.beyond.test.page.DatePickerPage;
import com.space.and.beyond.test.utils.DataUtils;
import com.space.and.beyond.test.utils.DateUtils;
import com.space.and.beyond.test.utils.Report;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.Date;
import java.util.List;
import static com.space.and.beyond.test.utils.dictionary.DateFormat.DAY;
import static com.space.and.beyond.test.utils.dictionary.DateFormat.MMMM_YYYY;
import static com.space.and.beyond.test.utils.dictionary.DateFormat.MONTH_NUMBER;
import static com.space.and.beyond.test.utils.dictionary.DateFormat.YEAR;
import static com.space.and.beyond.test.utils.dictionary.Message.FAIL;
import static com.space.and.beyond.test.utils.dictionary.Message.SUCCESS;

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

    public static String selectRandomOption(WebElement select, WebElement optBox, List<WebElement> options) {
        int index;
        String optionSelected = "";
        if (options.isEmpty()) {
            Report.reportFail(String.format(FAIL, "There are not options for current select"));
        } else {
            select.click();
            index = DataUtils.getFaker().number().numberBetween(0, options.size()-1);
            optionSelected = options.get(index).getText();
            Wait.forElementVisible(optBox);
            new Actions(driver).moveToElement(options.get(index)).perform();
            options.get(index).click();
            Wait.forElementInvisible(optBox);
        }
        return optionSelected;
    }

    public static void selectDate(Date date) {
        DatePickerPage datePickerPage = new DatePickerPage();
        datePickerPage.clickSelectYear();
        datePickerPage.clickOptionYear(DateUtils.getDateAsString(date, YEAR));
        findMonth(date);
        datePickerPage.clickLblDay(DateUtils.getDateAsString(date, DAY));
        datePickerPage.clickBtnOk();
    }

    private static void findMonth(Date date){
        DatePickerPage datePickerPage = new DatePickerPage();
        String foundDate = datePickerPage.getSelectedMonth();
        int expectedMonth = DateUtils.getDateAsInt(date, MONTH_NUMBER);
        int foundMonth = DateUtils.getDateAsInt(DateUtils.parseString(foundDate, MMMM_YYYY), MONTH_NUMBER);
        int difference = expectedMonth - foundMonth;
        if (difference < 0) {
            difference = difference * (-1);
            for (int i=0; i<difference; i++) {
                datePickerPage.clickBtnPreviousMonth();
            }
        } else if (difference > 0) {
            for (int i=0; i<difference; i++) {
                datePickerPage.clickBtnNextMonth();
            }
        }
        Report.reportInfo(String.format(SUCCESS, "Month found on date picker"));
    }

}
