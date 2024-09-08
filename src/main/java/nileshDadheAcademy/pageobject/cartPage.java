package nileshDadheAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nileshDadheAcademy.AbstractComponent.AbstractComponent;

public class cartPage extends AbstractComponent {
	WebDriver driver;
	
	 public cartPage(WebDriver driver) 
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	 

	@FindBy(xpath="//*[@class='cartSection']/h3") 
	List<WebElement> cartProducts;
	
	
	 @FindBy(xpath="//*[@class='totalRow']/button")
	WebElement checkout;

	 @FindBy(id="login")
	 WebElement submit;
	 
	 public boolean verifyProductDisplay(String productName)
	 {
			boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
			return match;
	 }
	 public CheckoutPage goToCheckout()
	 {
			checkout.click();
			return new CheckoutPage(driver);

	 }
	
}
