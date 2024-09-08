package nileshDadheAcademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nileshDadheAcademy.AbstractComponent.AbstractComponent;

public class confirmationPage extends AbstractComponent {
	WebDriver driver;
	 public confirmationPage(WebDriver driver) 
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	@FindBy(className="hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
		return confirmationMessage.getText();
		
	}

}
