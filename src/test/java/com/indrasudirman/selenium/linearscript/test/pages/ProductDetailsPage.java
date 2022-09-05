package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage {

    private By addToCartButtonLocator = By.xpath("//p[@id='add_to_cart']/button");

    public ProductDetailsPage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator));
    }

    public void addProductToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        WebElement addToCartButton = browser.findElement(addToCartButtonLocator);
        addToCartButton.click();
    }
}
