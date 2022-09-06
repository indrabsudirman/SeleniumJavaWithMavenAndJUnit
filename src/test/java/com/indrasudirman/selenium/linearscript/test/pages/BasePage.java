package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver browser;
    WebDriverWait wait;
    private By signInLinkLocator = By.cssSelector("a.login");
    private By siteLogoLocator = By.cssSelector("#header_logo > a");



    public BasePage(WebDriver browser) {
        this.browser = browser;
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    public LoginPage navigateToLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
        WebElement signInLink = browser.findElement(signInLinkLocator);
        signInLink.click();
        return new LoginPage(browser);
    }
    public HomePage navigateToHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(siteLogoLocator));
        WebElement homeLink = browser.findElement(siteLogoLocator);
        homeLink.click();
        return new HomePage(browser);
    }
}
