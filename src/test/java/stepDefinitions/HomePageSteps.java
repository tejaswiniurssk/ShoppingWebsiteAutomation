package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	String title;
    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    
    
    @Given("user is on Home Page")
    public void user_is_on_home_page() {
        title = homePage.homePageTitle();
        System.out.println("Home Page title is: " + title);
        Assert.assertEquals("My Store", title);
    }
    
    @When("homePage logo is displayed")
    public void homePage_logo_is_displayed() {
    	boolean flag = homePage.homePageIcon();
    	Assert.assertTrue(flag);
    }
    
    @Then("home page title should be {string}")
    public void home_page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));

    }
    
    @Given("search bar is displayed")
    public void search_bar_is_displayed() {
        boolean flag = homePage.searchBarIsDisplayed();
        Assert.assertTrue(flag);
    }
    
    @When("user enters the Item {string}")
    public void user_enters_the_item(String itemName) {
        homePage.userEntersItem(itemName);
    }

    @When("user enters the Item {string} {int}")
    public void user_enters_the_item(String sheetName, int rowNum) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData("src/test/resources/TestData/shoppingList.xlsx", sheetName);
        String Heading = testData.get(rowNum).get("SearchItem");
        homePage.userEntersItem(Heading);
    }

    @Then("user clicks on search icon")
    public void user_clicks_on_search_icon() {
        homePage.clickOnSearch();
    }

}
