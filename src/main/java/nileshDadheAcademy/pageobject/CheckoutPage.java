package nileshDadheAcademy.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nileshDadheAcademy.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	
	 public CheckoutPage(WebDriver driver) 
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Select Country']") 
	WebElement country;
	By resultCountry=By.className("ta-results");

	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button[2]")
	 WebElement selectCountry;
	
	@FindBy(className="action__submit")
	WebElement placeOrder;

	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(resultCountry);
		selectCountry.click();
		placeOrder.click();
	}
	
	public confirmationPage submitOrder()
	{
		placeOrder.click();
		return new confirmationPage(driver);
	}
	
}
