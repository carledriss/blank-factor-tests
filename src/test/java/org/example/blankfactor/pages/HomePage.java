package org.example.blankfactor.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//ul[@id='menu-main-menu']//span[normalize-space(.)='Industries']")
    private WebElement industriesButton;

    @FindBy(css = "button[data-cky-tag='accept-button']")
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//a[@title='Retirement and wealth']")
    private WebElement retirementAndWealthLink;

    public HomePage() {
        driver.get("https://blankfactor.com/");
    }

    public void clickAcceptAllCookies() {
        wait.getWait().until(ExpectedConditions.elementToBeClickable(acceptAllCookiesButton)).click();
    }

    public RetirementAndWealthPage navigateToRetirementAndWealthPage() {
        action.hover(industriesButton);
        action.click(retirementAndWealthLink);
        return new RetirementAndWealthPage();
    }

}