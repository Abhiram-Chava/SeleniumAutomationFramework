package Abhi.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Abhi.Ram.ConfirmationPage;
import Abhi.Ram.LandingPage;
import Abhi.Ram.ProductCatalogue;
import Abhi.Ram.cartPage;
import Abhi.Ram.checkoutPage;
import Abhi.Ram.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImpl extends BaseTest{
	public ConfirmationPage confirmationpage;
	public ProductCatalogue productCatalogue;
	public LandingPage landingpage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		landingpage = launchApplication();
	}
	
	@Given("^I logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
		productCatalogue = landingpage.LoginApplication(username, password);
	}
	
	@When("^I add the product (.+) to cart$")
	public void I_add_product_to_cart(String productName) {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^Chectout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		cartPage cartpage = productCatalogue.goToCartPage();
		boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkoutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("india");
		confirmationpage = checkoutpage.submitOrder();
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_is_displayed_on_confirmationpage(String string) {
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("^\"([^\"]*)]\" message is displayed$")
	public void something_message_is_displayed(String string) {
		Assert.assertEquals(string, landingpage.getErrorMessage());
		driver.close();
	}
}
