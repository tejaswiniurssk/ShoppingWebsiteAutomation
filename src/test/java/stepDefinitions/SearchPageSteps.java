package stepDefinitions;

import org.junit.Assert;

import com.pages.SearchPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageSteps {
	String title;
    private SearchPage searchPage = new SearchPage(DriverFactory.getDriver());

    @Given("user is on search page")
    public void user_is_on_search_page() {
        title = searchPage.getTitle();
        System.out.println("Search Page title is: " + title);
        Assert.assertEquals("Search - My Store", title);
    }
    @When("Item is displayed")
    public void item_is_displayed() throws InterruptedException {
        Thread.sleep(1000);
        boolean flag = searchPage.itemDisplayed();
        Assert.assertTrue(flag);
    }
    @Then("click on the Item")
    public void click_on_the_item() {
        searchPage.goToSearchedItem();
    }

}
