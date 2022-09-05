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
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        browser.manage().window().maximize();

        // Go to website
        browser.get("http://automationpractice.com/");

        // Navigate to login page
        HomePage homaPage = new HomePage(browser);
        homaPage.clickSignInButton() //Fluid syntax
                .setEmailAddress("petejenkins@test.com")
                .setPassword("Password1234") //Fluid syntax
                .clickSignInButton() //Fluid syntax
                .navigateToHomePage(); //Fluid syntax



        // Select the first product
        List<WebElement> productNameLinks = homaPage.getProductNameLinks();
        productNameLinks.get(1).click();


        // Add 1 item to the shopping cart
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(browser);
        productDetailsPage.clickAddToCartButton();

        // Proceed to checkout
        AddToCartConfirmationPopUp confirmationPopUp = new AddToCartConfirmationPopUp(browser);
        confirmationPopUp.clickProceedToCheckoutButton();

        // Verify we have 1 item in the shopping cart
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(browser);
        int numProducts = shoppingCartSummaryPage.getQuantity();
        assertEquals(numProducts, 1, String.format("Expected number of products in shopping cart was 1 but actual value was: %s", numProducts));


        // Close the browser
        browser.close();
    }
}
