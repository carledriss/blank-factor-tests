package org.example.blankfactor.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RetirementAndWealthPage extends AbstractPage {

    @FindBy(xpath = "//h1[text()='Retirement and wealth']")
    private WebElement title;

    @FindBy(css = "h2.section-title.scroll-animation")
    private WebElement sectionHeading;

    @FindBy(xpath = "//div[contains(normalize-space(.), 'Machine learning')]")
    private WebElement machineLearningCard;

    @FindBy(xpath = "//a[contains(@class,'btn-white-empty') and contains(@title, 'get started')]")
    private WebElement letsGetStartedButton;

    @FindBy(css = ".cards-grid-slider-wrapper .swiper-slide")
    private List<WebElement> cards;

    public String getThirdCardText() {
        action.click(sectionHeading);
        WebElement thirdCard = cards.get(2);
        thirdCard.click();
        return thirdCard.findElement(By.cssSelector(".card-text.small")).getText().trim();
    }

    public ContactPage clickLetsGetStarted() {
        action.scrollTo(letsGetStartedButton);
        action.click(letsGetStartedButton);
        return new ContactPage();
    }
}
