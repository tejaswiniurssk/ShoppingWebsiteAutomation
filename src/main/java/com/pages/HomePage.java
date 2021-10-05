package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

    // 1. By Locators: Object Repository
    private By searchBar = By.id("search_query_top");
    private By search = By.name("submit_search");

    // 2. Constructor of the page class:
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public String homePageTitle(){
        return driver.getTitle();
    }

    public boolean searchBarIsDisplayed(){
        return driver.findElement(searchBar).isDisplayed();
    }

    public void userEntersItem(String itemName){
        driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys(itemName);
    }

    public SearchPage clickOnSearch(){
        driver.findElement(search).click();

        return new SearchPage(driver);
    }
}
