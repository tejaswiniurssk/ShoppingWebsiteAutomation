package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedItemPage {

	private WebDriver driver;

    // 1. By Locators: Object Repository
//    private By addToCartBtn = By.xpath("//span[contains(text(),'Add to cart')]");
//    private By checkoutBtn = By.xpath("//span[contains(text(),'Proceed to checkout')]");
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement checkoutBtn;
	
	@FindBy(xpath = "//h1[contains(text(),'Printed Dress')]")
	private WebElement itemLabel;
	
    // 2. Constructor of the page class:
    public SearchedItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public String getTitle(){
        return driver.getTitle();
    }
    
    public boolean itemIsDisplayed() {
    	return itemLabel.isDisplayed();
    	
    }

    public OrderPage addToCart() throws InterruptedException {
        Thread.sleep(1000);
        addToCartBtn.click();
        Thread.sleep(2000);
        checkoutBtn.click();

        return new OrderPage(driver);
    }
}
