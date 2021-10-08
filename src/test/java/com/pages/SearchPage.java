package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	private WebDriver driver;

    // 1. By Locators: Object Repository
    //private By searchedItem = By.xpath("//a[contains(text(),'Printed Dress')]");
    
    @FindBy(xpath = "//a[contains(text(),'Printed Dress')]")
    private WebElement searchedItem;

    // 2. Constructor of the page class:
    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public String getTitle(){
        return driver.getTitle();
    }

    public boolean itemDisplayed(){
        return searchedItem.isDisplayed();
    }

    public SearchedItemPage goToSearchedItem(){
        searchedItem.click();
        return new SearchedItemPage(driver);

    }
}
