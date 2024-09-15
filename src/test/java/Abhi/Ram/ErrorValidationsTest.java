package Abhi.Ram;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Abhi.Ram.TestComponents.BaseTest;
import Abhi.Ram.TestComponents.retry;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups = {"ErrorHandling"},retryAnalyzer=retry.class)
	public void loginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		//String productname = "ZARA COAT 3";
		LandingPage landingpage = launchApplication();
		landingpage.LoginApplication("Salaar@gmail.com", "Salaar@gmail.com11");
		Assert.assertEquals("Incorrect email password.", landingpage.getErrorMessage());
	}

	@Test
	public void productErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String productname = "ZARA COAT 3";
		LandingPage landingpage = launchApplication();

		ProductCatalogue productcatalogue = landingpage.LoginApplication("Salaar@gmail.com", "Salaar@gmail.com1");

		//List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productname);

		cartPage cartpage = productcatalogue.goToCartPage();

		boolean match = cartpage.VerifyProductDisplay("abc");

		Assert.assertFalse(match);
	}

}
