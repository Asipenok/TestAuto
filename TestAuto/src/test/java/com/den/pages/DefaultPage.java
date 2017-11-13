package com.den.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class DefaultPage extends FactoryPage{

    @FindBy(css = "a[href='/']")
    private WebElement eventPosition;


    public DefaultPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnOtherCountryLink() {
        System.out.println("Navigate to main page");
        eventPosition.click();
        return new HomePage(driver);
    }
    public boolean isEventItemDisplayed(){
        return eventPosition.isDisplayed();
    }

}
