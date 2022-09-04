package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserAccountPage extends BasePage {

    public UserAccountPage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='myaccount-link-list']//a[contains(@href,'controller=history')]")));
    }

    public void navigateToHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='myaccount-link-list']//a[contains(@href,'controller=history')]")));
        WebElement homeLink = browser.findElement(By.cssSelector("a.home"));
        homeLink.click();
    }
}
