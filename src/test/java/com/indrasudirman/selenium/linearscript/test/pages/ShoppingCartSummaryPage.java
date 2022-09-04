package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartSummaryPage {

    private WebDriver browser;
    private WebDriverWait wait;

    public ShoppingCartSummaryPage(WebDriver browser) {
        this.browser = browser;
        // Wait for page load
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary_products_quantity")));
    }

    public int getQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary_products_quantity")));
        String numProductsLabelText = browser.findElement(By.id("summary_products_quantity")).getText();
        int spaceLocation = numProductsLabelText.indexOf(" ");
        int numProducts = Integer.parseInt(numProductsLabelText.substring(0, spaceLocation));
        return numProducts;
    }
}
