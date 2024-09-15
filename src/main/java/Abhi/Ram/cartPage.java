package Abhi.Ram;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abhi.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents {
	WebDriver driver;

	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	public boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}

	public checkoutPage goToCheckout() {
		checkoutEle.click();
		return new checkoutPage(driver);
	}

}

