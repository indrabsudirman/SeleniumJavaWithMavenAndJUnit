package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddToCartConfirmationPopUp extends BasePage {

    public AddToCartConfirmationPopUp(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
    }

    public void clickProceedToCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("//a[@title='Proceed to checkout']"));
        proceedToCheckoutButton.click();
    }
}
