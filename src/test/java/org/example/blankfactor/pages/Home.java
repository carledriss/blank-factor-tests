package org.example.blankfactor.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home extends AbstractPage {

    @FindBy(xpath = "//ul[@id='menu-main-menu']//span[normalize-space(.)='Industries']")
    private WebElement industriesButton;

    @FindBy(css = "button[data-cky-tag='accept-button']")
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//a[@title='Retirement and wealth']")
    private WebElement retirementAndWealthLink;

    public Home() {
        driver.get("https://blankfactor.com/");
    }

    public void clickAcceptAllCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllCookiesButton)).click();
    }

    public RetirementAndWealthPage navigateToRetirementAndWealthPage() {
        new Actions(driver).moveToElement(industriesButton).perform();
        action.click(retirementAndWealthLink);
        return new RetirementAndWealthPage();
    }

}