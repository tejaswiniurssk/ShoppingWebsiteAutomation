package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	private WebDriver driver;

    // 1. By Locators: Object Repository
    //private By cartItemName = By.xpath("//td//p//a[contains(text(),'Printed Dress')]");
    
    @FindBy(xpath = "//td//p//a[contains(text(),'Printed Dress')]")
    private List<WebElement> cartItemName;
    
    @FindBy(xpath = "//h1[@id='cart_title']")
    private WebElement cartTitle;
    
    // 2. Constructor of the page class:
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    //get the title of the page
    public String getTitle(){
        return driver.getTitle();
    }
   //check if cart title is displayed
    public boolean cartTitle() {
    	return cartTitle.isDisplayed();
    }

    //check if the searched item and cart item are same
    public List<String> correctItemCheck() throws InterruptedException {
        Thread.sleep(1000);
        List<String> cartList = new ArrayList<>();
        List<WebElement> cartValue = cartItemName;

        for (WebElement e : cartValue) {
            String text = e.getText();
            System.out.println(text);
            cartList.add(text);
        }
        return cartList;
    }

}
