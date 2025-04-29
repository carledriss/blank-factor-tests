package org.example.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyCustomWait {
    public static final long EXPLICIT_WAIT_IN_SECONDS = 10;

    protected WebDriverWait wait;

    protected MyCustomWait(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_IN_SECONDS));
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
