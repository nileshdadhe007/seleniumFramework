package nileshDadheAcademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nileshDadheAcademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	 public LandingPage(WebDriver driver) 
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	 //pagefactory @findBy meaning findElement(By.id("userEmail")
	@FindBy(id="userEmail") 
	WebElement userEmail;
	
	 @FindBy(id="userPassword")
	WebElement passwordEle;

	 @FindBy(id="login")
	 WebElement submit;
	 public void goTo()
	 {
			driver.get("https://rahulshettyacademy.com/client");

	 }
	 
	 public ProductCatolog loginApplication(String email,String password)
	 {
		 userEmail.sendKeys(email);
		 passwordEle.sendKeys(password);
		 submit.click();
		ProductCatolog ProductCatolog=new ProductCatolog(driver);
		return ProductCatolog;

	 }
}
