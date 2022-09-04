package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartSummaryPage extends BasePage {

    public ShoppingCartSummaryPage(WebDriver browser) {
        super(browser);
        // Wait for page load
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
