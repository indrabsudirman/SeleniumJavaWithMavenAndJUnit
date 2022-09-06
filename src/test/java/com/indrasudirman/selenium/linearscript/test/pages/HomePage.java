package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private By productLinksLocator = By.cssSelector("a.product-name");
    private By contactUsLocator = By.cssSelector("#contact-link > a");

    public HomePage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLocator));
    }

    public ProductDetailsPage selectProduct(int productIndex) {
        List<WebElement> productNameLinks = getProductNameLinks();
        productNameLinks.get(productIndex).click();
        return new ProductDetailsPage(browser);
    }

    public ProductDetailsPage selectFirstProduct() {
        selectProduct(0);
        return new ProductDetailsPage(browser);
    }



    public List<WebElement> getProductNameLinks() {
        wait.until(ExpectedConditions.elementToBeClickable(productLinksLocator));
        List<WebElement> productLinks = browser.findElements(productLinksLocator);
        return productLinks;
    }
}
