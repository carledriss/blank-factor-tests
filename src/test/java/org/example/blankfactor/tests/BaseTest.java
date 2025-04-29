package org.example.blankfactor.tests;


import org.example.core.ui.BrowserFactory;
import org.example.core.ui.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public abstract class BaseTest {

    protected WebDriver getWebdriver() {
        WebDriver driverSession = DriverFactory.getDriver();
        if (driverSession == null || ((RemoteWebDriver) driverSession).getSessionId() == null) {
            String browser = System.getProperty("browser", "chrome");
            WebDriver driver = BrowserFactory.getBrowser(browser);
            driver.manage().window().maximize();
            DriverFactory.addDriver(driver);
        }
        return DriverFactory.getDriver();
    }

    @AfterTest
    public void teardown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}