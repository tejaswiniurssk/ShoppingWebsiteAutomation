package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

    // 1. By Locators: Object Repository
//    private By searchBar = By.id("search_query_top");
//    private By search = By.name("submit_search");
	
	@FindBy(id = "search_query_top")
	private WebElement searchBar;
	
	@FindBy(name = "submit_search")
	private WebElement search;
	
	@FindBy(xpath = "//a//img[@class='logo img-responsive']")
	private WebElement homePageIcon;
	

    // 2. Constructor of the page class:
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    
    //get the title of home page
    public String homePageTitle(){
        return driver.getTitle();
    }
    
    //check if the home page icon is displayed
    public boolean homePageIcon() {
    	return homePageIcon.isDisplayed();
    }

  //check if the search bar is displayed
    public boolean searchBarIsDisplayed(){
        return searchBar.isDisplayed();
    }

    //click on search bar and send the item name
    public void userEntersItem(String itemName){
        searchBar.click();
        searchBar.sendKeys(itemName);
    }

    //click on search icon
    public SearchPage clickOnSearch(){
        search.click();

        return new SearchPage(driver);
    }
}
