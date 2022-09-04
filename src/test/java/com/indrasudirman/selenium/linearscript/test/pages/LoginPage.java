package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver browser) {
        super(browser);
        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public void setEmailAddress(String emailAddress){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement emailTextBox = browser.findElement(By.id("email"));
        emailTextBox.clear();
        emailTextBox.sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
        WebElement passwordTextBox = browser.findElement(By.id("passwd"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("SubmitLogin")));
        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }
}
