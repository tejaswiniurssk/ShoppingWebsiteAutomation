package stepDefinitions;

import java.util.Properties;

import org.testng.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;
    private ConfigReader configReader;
    Properties prop;
    
    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application() {
    	configReader = new ConfigReader();
    	prop = configReader.init_prop();
    	String username = prop.getProperty("username");
        String password = prop.getProperty("password");
    	accountsPage = loginPage.doLogin(username, password);
    }
    
	@Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts Page title is: " + title);
    }
	
	@When("my account label is displayed")
    public void my_account_label_is_displayed() {
		boolean flag = accountsPage.accountLabelisDisplayed();
		Assert.assertTrue(flag);
    }

    @Then("user clicks on home page icon")
    public void user_clicks_on_home_page_icon() {
        accountsPage.clickOnHomePageIcon();
    }
    

}
