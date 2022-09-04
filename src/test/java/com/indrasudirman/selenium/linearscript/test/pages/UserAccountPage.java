package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAccountPage {

    private WebDriver browser;
    private WebDriverWait wait;

    public UserAccountPage(WebDriver browser) {
        this.browser = browser;
        // Wait for page load
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='myaccount-link-list']//a[contains(@href,'controller=history')]")));
    }

    public void navigateToHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='myaccount-link-list']//a[contains(@href,'controller=history')]")));
        WebElement homeLink = browser.findElement(By.cssSelector("a.home"));
        homeLink.click();
    }
}
