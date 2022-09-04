package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver browser) {
        super(browser);
        // Wait for page load
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
