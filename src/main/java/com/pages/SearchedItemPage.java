package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchedItemPage {

	private WebDriver driver;

    // 1. By Locators: Object Repository
    private By addToCartBtn = By.xpath("//span[contains(text(),'Add to cart')]");
    private By checkoutBtn = By.xpath("//span[contains(text(),'Proceed to checkout')]");

    // 2. Constructor of the page class:
    public SearchedItemPage(WebDriver driver){
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public String getTitle(){
        return driver.getTitle();
    }

    public OrderPage addToCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(addToCartBtn).click();
        Thread.sleep(2000);
        driver.findElement(checkoutBtn).click();

        return new OrderPage(driver);
    }
}
