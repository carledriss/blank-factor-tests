package org.example.blankfactor.tests;

import org.example.blankfactor.pages.ContactPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlankFactorTests extends BaseTest {

    private static final String EXPECTED_CONTACT_URL = "https://blankfactor.com/contact/";
    private static final String EXPECTED_TEXT = "Automate your operations and get to market quickly and securely. Leverage predictive data analytics using machine learning to build reliable, yet forward-thinking financial solutions.";

    @Test
    public void testCopyThirdTileTextOnHoverFromRetirementServicesSection() {
        homePage.clickAcceptAllCookies();
        String actualText = homePage.navigateToRetirementAndWealthPage()
                .getThirdCardText();
        Assert.assertEquals(actualText, EXPECTED_TEXT);
    }

    @Test
    public void testClickGetStartedButtonAndVerifyNavigation() {
        ContactPage contactPage = homePage.navigateToRetirementAndWealthPage()
                .clickLetsGetStarted();
        Assert.assertEquals(contactPage.getCurrentUrl(), EXPECTED_CONTACT_URL);
        contactPage.printPageTitle();
    }

}