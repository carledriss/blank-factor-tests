package org.example.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverAction {

    private final WebDriver driver;

    private final WebDriverWait wait;

    public WebdriverAction(final WebDriver driver, final MyCustomWait wait) {
        this.driver = driver;
        this.wait = wait.getWait();
    }

    public void click(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void click(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void jsClick(final WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    public void scrollTo(final WebElement webElement) {

        new Actions(driver).scrollToElement(webElement).perform();
    }

    public void jsScrollTo(final WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", webElement
        );
    }

    public String getText(final WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
    }

    public String getText(final By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void setValue(final WebElement webElement, final String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void clear(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement)).clear();
    }

    public void hover(final WebElement webElement) {
        new Actions(driver).moveToElement(webElement).perform();
    }
}
