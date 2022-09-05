package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// Page Factory using @FindBy, like sample below
public class PageFactorySampleInLoginPage extends BasePage {

    @FindBy(id = "email")
    protected WebElement emailAddressTextBox;

    @FindBy(id = "passwd")
    protected WebElement passwordTextBox;

    @FindBy(id = "SubmitLogin")
    protected WebElement signInButton;

    public PageFactorySampleInLoginPage(WebDriver browser) {
        super(browser);
        PageFactory.initElements(browser, this);
    }

    public void setEmailAddress(String emailAddress) {
        emailAddressTextBox.clear();
        emailAddressTextBox.sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
