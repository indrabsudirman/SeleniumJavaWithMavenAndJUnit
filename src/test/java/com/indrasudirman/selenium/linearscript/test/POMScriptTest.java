package com.indrasudirman.selenium.linearscript.test;

import com.indrasudirman.selenium.linearscript.test.pages.HomePage;
import com.indrasudirman.selenium.linearscript.test.pages.ShoppingCartSummaryPage;
import com.indrasudirman.selenium.linearscript.test.pages.components.ShoppingCartItem;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class POMScriptTest {

    @Test
    public void POMScriptAddToCartTest() throws Exception {

        // Initialization
        System.setProperty("webdriver.chrome.driver", "/home/koinworks/selenium_lib/chromedriver_linux64/chromedriver");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();

        // Go to website
        browser.get("http://automationpractice.com/");

        // Navigate to login page
        HomePage homaPage = new HomePage(browser);
        homaPage.navigateToLoginPage()
                .login("petejenkins@test.com", "Password12341")
                .navigateToHomePage()
                .selectFirstProduct()
                .addProductToShoppingCart()
                .proceedToCheckout()
                .navigateToHomePage()
                .selectProduct(1)
                .addProductToShoppingCart()
                .proceedToCheckout();

        // Verify we have 1 item in the shopping cart
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(browser);
//        int numProducts = shoppingCartSummaryPage.getQuantity();
//        assertEquals(numProducts, 1, String.format("Expected number of products in shopping cart was 1 but actual value was: %s", numProducts));
        List<ShoppingCartItem> cartItems = shoppingCartSummaryPage.getShoppingCart();
        double totalItemAmounts = cartItems.stream().mapToDouble(ShoppingCartItem::getTotalPrice).sum();
        totalItemAmounts = Math.round(totalItemAmounts*100)/100.0d;
        double totalAmount = shoppingCartSummaryPage.getTotalPrice();
        assertEquals(totalItemAmounts, totalAmount, "Total value of items does not equal total quoted");

        // Close the browser this test
        browser.close();
    }
}
