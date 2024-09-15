package Abhi.Ram;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abhi.AbstractComponents.AbstractComponents;

public class orderPage extends AbstractComponents {
	WebDriver driver;

	public orderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;

	public boolean VerifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}

}

