package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='add_to_cart']/button")));
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id='add_to_cart']/button")));
        WebElement addToCartButton = browser.findElement(By.xpath("//p[@id='add_to_cart']/button"));
        addToCartButton.click();
    }
}
