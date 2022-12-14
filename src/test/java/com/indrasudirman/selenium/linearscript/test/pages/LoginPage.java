package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By emailAddressLocator = By.id("email");
    private By passwordTextBoxLocator = By.id("passwd");
    private By signInButtonLocator = By.id("SubmitLogin");
    private By errorMessageLocator = By.cssSelector("#center_column > div.alert.alert-danger > ol > li");

    public LoginPage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
    }

    public UserAccountPage login(String emailAddress, String password) throws Exception {
        setEmailAddress(emailAddress);
        setPassword(password);
        clickSignInButton();
        return new UserAccountPage(browser);

    }

    private LoginPage setEmailAddress(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
        WebElement emailTextBox = browser.findElement(emailAddressLocator);
        emailTextBox.clear();
        emailTextBox.sendKeys(emailAddress);
        return this;
    }

    private LoginPage setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
        WebElement passwordTextBox = browser.findElement(passwordTextBoxLocator);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        return this;
    }

    private UserAccountPage clickSignInButton() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
        WebElement signInButton = browser.findElement(signInButtonLocator);
        signInButton.click();
        checkForLoginFailure();
        return new UserAccountPage(browser);
    }

    private void checkForLoginFailure() throws Exception {
        try {
            waitForPageTitle("My account - ");
        } catch (TimeoutException e) {
            String errorMessage = browser.findElement(errorMessageLocator).getText();
            throw new Exception("Login failure: " + errorMessage);
        }
    }
}
