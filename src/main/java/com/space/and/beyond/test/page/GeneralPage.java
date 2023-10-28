package com.space.and.beyond.test.page;

import com.space.and.beyond.test.factory.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class GeneralPage {

    public GeneralPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
