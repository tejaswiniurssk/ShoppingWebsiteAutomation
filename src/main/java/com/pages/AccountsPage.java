package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
	private WebDriver driver;

    // 1. By Locators: Object Repository
    private By homePageIcon = By.xpath("//a//i[@class='icon-home']");

    // 2. Constructor of the page class:
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public String getAccountsPageTitle() {
        return driver.getTitle();
    }

    public HomePage clickOnHomePageIcon(){
        driver.findElement(homePageIcon).click();
        return new HomePage(driver);
    }

}
