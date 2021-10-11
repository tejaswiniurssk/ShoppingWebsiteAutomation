package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	private WebDriver driver;

    // 1. By Locators: Object Repository
    //private By homePageIcon = By.xpath("//a//i[@class='icon-home']");
	
	@FindBy(xpath = "//a//i[@class='icon-home']")
	private WebElement homePageIcon;
	
	@FindBy(xpath = "//h1[contains(text(),'My account')]")
	private WebElement myAccountsLabel;

    // 2. Constructor of the page class:
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public String getAccountsPageTitle() {
        return driver.getTitle();
    }
    
    //check if the label is displayed
    public boolean accountLabelisDisplayed() {
    	return myAccountsLabel.isDisplayed();
    }

    //check if the homepage icon is displayed
    public HomePage clickOnHomePageIcon(){
        homePageIcon.click();
        return new HomePage(driver);
    }

}
