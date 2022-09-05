package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserAccountPage extends BasePage {

    private By homeLinkLocator = By.cssSelector("a.home");

    public UserAccountPage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLinkLocator));
    }

    public void navigateToHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLinkLocator));
        WebElement homeLink = browser.findElement(homeLinkLocator);
        homeLink.click();
    }
}
