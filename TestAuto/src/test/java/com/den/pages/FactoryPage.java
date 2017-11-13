package com.den.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class FactoryPage {
    protected WebDriver driver;

    protected FactoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String assertCurrentURL(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
}
