package org.example.core.ui;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public static final long DEFAULT_IMPLICIT_TIMEOUT_IN_SECONDS = 15;

    protected WebDriver driver;

    protected MyCustomWait wait;

    protected WebdriverAction action;

    protected AbstractPage(final WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_IMPLICIT_TIMEOUT_IN_SECONDS));
        this.wait = new MyCustomWait(driver);
        this.action = new WebdriverAction(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
