package com.den.design;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import static com.den.locators.ProjectLocators.GREEN_PANEL;
import static com.den.locators.ProjectLocators.START_URL;

public class BasicTest {
    protected static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            setChromeDriver();
        }
        return driver;
    }

    public static void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(true);
        driver = new ChromeDriver(capabilities);
    }

    @BeforeClass(description = "Start browser")
    public void setUp() {
        getDriver().get(START_URL);
        WebElement expectedElement = (new WebDriverWait(driver, 5)).
                until(new ExpectedCondition<WebElement>() {
                          public WebElement apply(WebDriver webDriver) {
                              return webDriver.findElement(GREEN_PANEL);
                          }
                      }
                );
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void enableJavaScript() {

    }

    @BeforeClass(dependsOnMethods = "setUp", description = "Add implicite wait and maximize window")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() throws Exception {
        driver.quit();
    }

}
