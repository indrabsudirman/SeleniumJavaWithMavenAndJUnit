package com.indrasudirman.selenium.linearscript.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver browser;
    WebDriverWait wait;

    public BasePage(WebDriver browser) {
        this.browser = browser;
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
}
