package org.example.blankfactor.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(ContactPage.class);

    @FindBy(xpath = "//*[@class='h1-5 heading section-title']")
    private WebElement title;

    public ContactPage(final WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return action.getText(title);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void printPageTitle() {
        LOGGER.info("Page Title : %s".formatted(getPageTitle()));
    }
}
