package org.example.blankfactor.tests;

import org.example.blankfactor.pages.ContactPage;
import org.example.blankfactor.pages.Home;
import org.example.core.ui.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BlankFactorTests {

    private static final String EXPECTED_CONTACT_URL = "https://blankfactor.com/contact/";
    private static final String EXPECTED_TEXT = "Automate your operations and get to market quickly and securely. Leverage predictive data analytics using machine learning to build reliable, yet forward-thinking financial solutions.";

    private Home home;

    @BeforeTest
    public void setup() {
        home = new Home();
    }

    @Test
    public void testCopyThirdTileTextOnHoverFromRetirementServicesSection() {
        home.clickAcceptAllCookies();
        String actualText = home.navigateToRetirementAndWealthPage().getThirdCardText();
        Assert.assertEquals(actualText, EXPECTED_TEXT);
    }

    @Test
    public void testClickGetStartedButtonAndVerifyNavigation() {
        ContactPage contactPage = home.navigateToRetirementAndWealthPage().clickLetsGetStarted();
        Assert.assertEquals(contactPage.getCurrentUrl(), EXPECTED_CONTACT_URL);
        contactPage.printPageTitle();
    }

    @AfterTest
    public void teardown() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}