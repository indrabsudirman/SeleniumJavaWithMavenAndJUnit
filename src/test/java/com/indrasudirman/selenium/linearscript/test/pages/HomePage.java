package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver browser;
    private WebDriverWait wait;

    public HomePage(WebDriver browser) {
        this.browser = browser;
        // Wait for page load
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login")));
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login")));
        WebElement signInLink = browser.findElement(By.cssSelector("a.login"));
        signInLink.click();
    }

    public List<WebElement> getProductNameLinks() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.product-name")));
        List<WebElement> productLinks = browser.findElements(By.cssSelector("a.product-name"));
        return productLinks;
    }
}
