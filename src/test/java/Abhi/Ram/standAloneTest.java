package Abhi.Ram;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Abhi.Ram.TestComponents.BaseTest;

public class standAloneTest extends BaseTest {
	String productname = "ZARA COAT 3";
	@Test
	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub
		LandingPage landingpage = launchApplication();

		ProductCatalogue productCatalogue = landingpage.LoginApplication("Salaar@gmail.com", "Salaar@gmail.com1");

		//List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productname);

		cartPage cartpage = productCatalogue.goToCartPage();

		boolean match = cartpage.VerifyProductDisplay(productname);

		Assert.assertTrue(match);

		checkoutPage checkoutpage = cartpage.goToCheckout();

		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();

		// a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();

		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		// driver.close();
	}

	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() throws IOException {
		LandingPage landingpage = launchApplication();
		ProductCatalogue productCatalogue = landingpage.LoginApplication("Salaar@gmail.com", "Salaar@gmail.com1");
		orderPage ordersPage= productCatalogue.goToOrdersPage();
		ordersPage.VerifyOrderDisplay(productname);
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productname));
	}

}
