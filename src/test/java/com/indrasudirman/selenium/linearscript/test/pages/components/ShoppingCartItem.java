package com.indrasudirman.selenium.linearscript.test.pages.components;

import org.openqa.selenium.WebElement;

public class ShoppingCartItem {

    private String productName;
    private String SKU;
    private String color;
    private boolean inStock;
    private double unitPrice;
    private int quantity;
    private double totalPrice;

    private WebElement productImageLink;
    private WebElement productNameLink;
    private WebElement increaseQuantityButton;
    private WebElement decreaseQuantityButton;
    private WebElement removeProductButton;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProductImageLink(WebElement productImageLink) {
        this.productImageLink = productImageLink;
    }

    public void setProductNameLink(WebElement productNameLink) {
        this.productNameLink = productNameLink;
    }

    public void setIncreaseQuantityButton(WebElement increaseQuantityButton) {
        this.increaseQuantityButton = increaseQuantityButton;
    }

    public void setDecreaseQuantityButton(WebElement decreaseQuantityButton) {
        this.decreaseQuantityButton = decreaseQuantityButton;
    }

    public void setRemoveProductButton(WebElement removeProductButton) {
        this.removeProductButton = removeProductButton;
    }
}
