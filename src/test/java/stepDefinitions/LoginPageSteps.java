package stepDefinitions;

import java.util.Properties;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps{
    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    private ConfigReader configReader;
    Properties prop;

    @Given("user is on login page")
    public void user_is_on_login_page(){
    	title = loginPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));

    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @When("user logs into the application")
    public void user_logs_into_the_application() {
    	configReader = new ConfigReader();
    	prop = configReader.init_prop();
    	
        String un = prop.getProperty("username");
        String pw = prop.getProperty("password");
        
        loginPage.enterLoginCredentials(un, pw);
    }

    @Then("user will be navigated to Accounts Page")
    public void user_will_be_navigated_to_accounts_page() {
        String AccountPageTitle = loginPage.AccountsPageTitle();
        System.out.println("Page title is: " + AccountPageTitle);
        Assert.assertEquals("My account - My Store", AccountPageTitle);
    }
}