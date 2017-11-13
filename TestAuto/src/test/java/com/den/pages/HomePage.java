package com.den.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends FactoryPage{

    public HomePage (WebDriver driver){
        super(driver);
    }
    @FindBy(css = "a[href='/events']")
    private WebElement eventItem;

       public DefaultPage clickOnEventItemLink() {
        System.out.println("Navigate to main page");
        eventItem.click();
        return new DefaultPage(driver);
    }


}
