package org.example.blankfactor.tests;

import org.example.blankfactor.pages.ContactPage;
import org.example.blankfactor.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlankFactorTests extends BaseTest {

    private static final String EXPECTED_CONTACT_URL = "https://blankfactor.com/contact/";
    private static final String EXPECTED_TEXT = "Automate your operations and get to market quickly and securely. Leverage predictive data analytics using machine learning to build reliable, yet forward-thinking financial solutions.";

    @Test
    public void testCopyThirdTileTextOnHoverFromRetirementServicesSection() {
        WebDriver driver = getWebdriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickAcceptAllCookies();
        String actualText = homePage.navigateToRetirementAndWealthPage()
                .getThirdCardText();
        Assert.assertEquals(actualText, EXPECTED_TEXT);
    }

    @Test
    public void testClickGetStartedButtonAndVerifyNavigation() {
        WebDriver driver = getWebdriver();
        HomePage homePage = new HomePage(driver);
        ContactPage contactPage = homePage.navigateToRetirementAndWealthPage()
                .clickLetsGetStarted();
        Assert.assertEquals(contactPage.getCurrentUrl(), EXPECTED_CONTACT_URL);
        contactPage.printPageTitle();
    }

}