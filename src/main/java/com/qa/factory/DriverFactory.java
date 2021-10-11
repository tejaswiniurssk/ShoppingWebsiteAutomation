package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); 
	// Used for parallel execution
	/**
	 * This method is used to initialize the threadlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return 
	 * @return this will return tldriver.
	 */
	
	public WebDriver init_driver(String browser, String url) {
		System.out.println("browser value is:"+ browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println("Please pass the correct browser value");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(url);
		
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	

}
