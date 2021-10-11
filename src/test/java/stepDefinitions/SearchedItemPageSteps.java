package stepDefinitions;

import org.testng.Assert;

import com.pages.SearchedItemPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchedItemPageSteps {
	
	 String title;
	    private SearchedItemPage searchedItemPage = new SearchedItemPage(DriverFactory.getDriver());

	    @Given("user is on Searched Item Page")
	    public void user_is_on_searched_item_page() {
	        title = searchedItemPage.getTitle();
	        System.out.println("Searched Item Page title is: " + title);
	    }
	    @Then("user clicks on add to cart")
	    public void user_clicks_on_add_to_cart() throws InterruptedException {
	        searchedItemPage.addToCart();
	    }
	    
	    @When("{string} is Displayed")
	    public void is_displayed(String string) {
	    	boolean flag = searchedItemPage.itemIsDisplayed();
	    	Assert.assertTrue(flag);
	    }

}
