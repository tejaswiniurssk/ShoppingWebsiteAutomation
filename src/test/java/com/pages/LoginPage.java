package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	// 1. By Locators: Object Repository
	//private By emailId = By.id("email");
	//private By password = By.id("passwd");
	//private By signInButton = By.id("SubmitLogin");
	//private By forgotPwdLink = By.linkText("Forgot your password?");
	
	@FindBy(id= "email")
	private WebElement emailId;
	
	@FindBy(id= "passwd")
	private WebElement password;
	
	@FindBy(id= "SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(linkText =  "Forgot your password?")
	private WebElement forgotPwdLink;
	

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	//get title of login page
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	//check is forgot password link is displayed
	public boolean isForgotPwdLinkExist() {
		return forgotPwdLink.isDisplayed();
	}

	//send username, password and click on signIn Button
	public void enterLoginCredentials(String username, String password) {
		emailId.sendKeys(username);
		this.password.sendKeys(password);
		signInButton.click();
	}

	//get Accounts page title to check if it is on correct landing page
	public String AccountsPageTitle() {
		return driver.getTitle();

	}

	public AccountsPage doLogin(String username, String password) {
	  System.out.println("login with: " + username + " and " + password);
	  emailId.sendKeys(username);
	  this.password.sendKeys(password);
	  signInButton.click();
	  
	  return new AccountsPage(driver); 
	  
	}
	 
}
