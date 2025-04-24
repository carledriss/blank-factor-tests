package org.example.blankfactor.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contact extends AbstractPage {

    @FindBy(xpath = "//*[@class='h1-5 heading section-title']")
    private WebElement title;

    public String getPageTitle() {
        return action.getText(title);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
