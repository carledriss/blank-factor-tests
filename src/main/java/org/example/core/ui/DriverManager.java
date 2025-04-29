package org.example.core.ui;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final DriverManager INSTANCE = new DriverManager();

    private final WebDriver driver;

    private DriverManager() {
        String browser = System.getProperty("browser", "chrome");
        driver = BrowserFactory.getBrowser(browser);
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
