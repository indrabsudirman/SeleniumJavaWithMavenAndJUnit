package com.indrasudirman.selenium.linearscript.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LinearScriptTest {

    @Test
    public void LinearScriptAddToCartTest() {

        // Initialization
        System.setProperty("webdriver.chrome.driver", "/home/koinworks/selenium_lib/chromedriver_linux64/chromedriver");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        browser.manage().window().maximize();

        // Go to website
        browser.get("http://automationpractice.com/");

        // Navigate to login page
        WebElement signInLink = browser.findElement(By.cssSelector("a.login"));
        signInLink.click();

        // Log in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement emailTextBox = browser.findElement(By.id("email"));
        emailTextBox.sendKeys("petejenkins@test.com");
        WebElement passwordTextBox = browser.findElement(By.id("passwd"));
        passwordTextBox.sendKeys("Password1234");
        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        // Navigate back to home page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.home")));
        WebElement homeLink = browser.findElement(By.cssSelector("a.home"));
        homeLink.click();

        // Select the first product
        List<WebElement> productLinks = browser.findElements(By.cssSelector("a.product-name"));
        wait.until(ExpectedConditions.elementToBeClickable(productLinks.get(0)));
        productLinks.get(0).click();

        // Add 1 item to the shopping cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='add_to_cart']/button")));
        WebElement addToCartButton = browser.findElement(By.xpath("//p[@id='add_to_cart']/button"));
        addToCartButton.click();

        // Proceed to checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("//a[@title='Proceed to checkout']"));
        proceedToCheckoutButton.click();

        // Verify we have 1 item in the shopping cart
        String numProductsLabelText = browser.findElement(By.id("summary_products_quantity")).getText();
        int spaceLocation = numProductsLabelText.indexOf(" ");
        int numProducts = Integer.parseInt(numProductsLabelText.substring(0, spaceLocation));
        assertEquals(numProducts, 1, String.format("Expected number of products in shopping cart was 1 but actual value was: %s", numProducts));
        // Close the browser
        browser.close();
    }
}
