package com.den.design;

import com.den.pages.DefaultPage;
import com.den.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.den.design.BasicTest.driver;
import static com.den.locators.ProjectLocators.HOME_PAGE_URL;

public class PagesTest {

    @Test
    public void EventItemIsDisplayed() {
        boolean b = new DefaultPage(driver).isEventItemDisplayed();
        Assert.assertEquals(b, true);
    }

    @Test (dependsOnMethods = {"EventItemIsDisplayed"})
    public void clickOnEventItemLink() {
        new HomePage(driver).clickOnEventItemLink();

    }

//    @Test(dependsOnMethods = {"clickOnEventItemLink"})
//    public void inspectEventPagesOpened(){
//        String registerURL = new DefaultPage(driver).assertCurrentURL();
//        Assert.assertEquals(registerURL,HOME_PAGE_URL);
//
//    }
//
//    @Test (dependsOnMethods = {"inspectEventPagesOpened"})
//    public void assertEventPagesIsDisplayed() {
//        boolean b = new DefaultPage(driver).isEventPositionDisplayed();
//        Assert.assertEquals(b, true);
//    }


}
