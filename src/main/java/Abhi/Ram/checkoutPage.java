package Abhi.Ram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abhi.AbstractComponents.AbstractComponents;

public class checkoutPage extends AbstractComponents{

	WebDriver driver;

	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(css = ".action__submit")
	WebElement submit;

	@FindBy(xpath = "(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")
	WebElement selectCountry;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitforElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		Actions a = new Actions(driver);
		a.moveToElement(submit).click().build().perform();
		return new ConfirmationPage(driver);
	}

}
