package stepDefs;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ItemPage;
import pages.ShoppingCartPage;

public class OrderStepDef extends TestBase{
ItemPage itemPage;
	HomePage homepage;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutpage;

@Given("User is on Home Page")
public void user_is_on_home_page() {
    initialize();
}
@When("User search an Item {string}")
public void user_search_an_item(String strItem) {
   homepage=new HomePage();
   homepage.searchItem(strItem);
}
@Then("Item must be listed")
public void item_must_be_listed() {
	itemPage =new ItemPage();
	Assert.assertTrue(itemPage.isItemListed());
}

@When("User Add item")
public void user_add_item() {
  itemPage.viewItemDetail();
  itemPage.addItem();
}
@Then("Item should be added to cart")
public void item_should_be_added_to_cart() {
	cartPage=new ShoppingCartPage();
	Assert.assertTrue(cartPage.isItemAdded());
}
@When("user do the checkout")
public void user_do_the_checkout() {
	cartPage=new ShoppingCartPage();
   cartPage.checkOut();
}
@Then("Should display checkout page")
public void should_display_checkout_page() {
	checkoutpage= new CheckoutPage();
	Assert.assertTrue(checkoutpage.isCheckOutPage());
}

@AfterAll
public static void teardown() {
	driver.close();
	
}
}
