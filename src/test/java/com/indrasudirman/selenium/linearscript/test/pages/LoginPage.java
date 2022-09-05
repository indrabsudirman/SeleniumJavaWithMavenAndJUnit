package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By emailAddressLocator = By.id("email");
    private By passwordTextBoxLocator = By.id("passwd");
    private By signInButtonLocator = By.id("SubmitLogin");

    public LoginPage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
    }

    public void setEmailAddress(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
        WebElement emailTextBox = browser.findElement(emailAddressLocator);
        emailTextBox.clear();
        emailTextBox.sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
        WebElement passwordTextBox = browser.findElement(passwordTextBoxLocator);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
        WebElement signInButton = browser.findElement(signInButtonLocator);
        signInButton.click();
    }
}