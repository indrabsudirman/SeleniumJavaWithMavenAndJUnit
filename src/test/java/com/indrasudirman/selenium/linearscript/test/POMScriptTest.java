package com.indrasudirman.selenium.linearscript.test;

import com.indrasudirman.selenium.linearscript.test.pages.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class POMScriptTest {

    @Test
    public void POMScriptAddToCartTest() {

        // Initialization
        System.setProperty("webdriver.chrome.driver", "/home/koinworks/selenium_lib/chromedriver_linux64/chromedriver");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();

        // Go to website
        browser.get("http://automationpractice.com/");

        // Navigate to login page
        HomePage homaPage = new HomePage(browser);
        homaPage.navigateToLoginPage(); //Fluid syntax

        // Log in
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("petejenkins@test.com", "Password1234");

        // Navigate back to home page
        UserAccountPage userAccountPage = new UserAccountPage(browser);
        userAccountPage.navigateToHomePage();


        // Select the first product
        homaPage.selectProduct(0);


        // Add 1 item to the shopping cart
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(browser);
        productDetailsPage.addProductToShoppingCart();

        // Proceed to checkout
        AddToCartConfirmationPopUp confirmationPopUp = new AddToCartConfirmationPopUp(browser);
        confirmationPopUp.proceedToCheckout();

        // Verify we have 1 item in the shopping cart
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(browser);
        int numProducts = shoppingCartSummaryPage.getQuantity();
        assertEquals(numProducts, 1, String.format("Expected number of products in shopping cart was 1 but actual value was: %s", numProducts));


        // Close the browser
        browser.close();
    }
}
