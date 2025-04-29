package org.example.blankfactor.tests;

import org.example.blankfactor.pages.HomePage;
import org.example.core.ui.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected HomePage homePage;

    @BeforeTest
    public void setup() {
        homePage = new HomePage();
    }

    @AfterTest
    public void teardown() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}