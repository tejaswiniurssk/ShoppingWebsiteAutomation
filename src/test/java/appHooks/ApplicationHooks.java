package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    //Initialize property file 
    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    //read the property file and get browsername and url 
    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName, url);
    }

    //quit the browser once after TC execution
    @After(order = 0) //executed 2nd
    public void quitBrowser() {
        driver.quit();
    }

    //If TC fails, then take a screenshot and save
    @After(order = 1) // executed 1st
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

}
