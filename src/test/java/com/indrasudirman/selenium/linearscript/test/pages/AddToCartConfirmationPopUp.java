package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddToCartConfirmationPopUp extends BasePage {

    private By proceedToCheckOutButtonLocator = By.xpath("//a[@title='Proceed to checkout']");

    public AddToCartConfirmationPopUp(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutButtonLocator));
    }

    public void clickProceedToCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButtonLocator));
        WebElement proceedToCheckoutButton = browser.findElement(proceedToCheckOutButtonLocator);
        proceedToCheckoutButton.click();
    }
}
