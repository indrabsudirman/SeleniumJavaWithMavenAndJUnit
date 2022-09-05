package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private By signInLinkLocator = By.cssSelector("a.login");
    private By productLinksLocator = By.cssSelector("a.product-name");

    public HomePage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
        WebElement signInLink = browser.findElement(signInLinkLocator);
        signInLink.click();
    }

    public List<WebElement> getProductNameLinks() {
        wait.until(ExpectedConditions.elementToBeClickable(productLinksLocator));
        List<WebElement> productLinks = browser.findElements(productLinksLocator);
        return productLinks;
    }
}
