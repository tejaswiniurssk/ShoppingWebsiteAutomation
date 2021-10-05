package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
	private WebDriver driver;

    // 1. By Locators: Object Repository
    private By cartItemName = By.xpath("//td//p//a[contains(text(),'Printed Dress')]");
    
    // 2. Constructor of the page class:
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public String getTitle(){
        return driver.getTitle();
    }

    public List<String> correctItemCheck() throws InterruptedException {
        Thread.sleep(1000);
        List<String> cartList = new ArrayList<>();
        List<WebElement> cartValue = driver.findElements(cartItemName);

        for (WebElement e : cartValue) {
            String text = e.getText();
            System.out.println(text);
            cartList.add(text);
        }
        return cartList;
    }

}
