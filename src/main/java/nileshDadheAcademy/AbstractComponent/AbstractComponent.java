package nileshDadheAcademy.AbstractComponent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nileshDadheAcademy.pageobject.cartPage;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));

	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;

	public void waitForElementToAppear(By findby)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public cartPage goToCartPage()
	{
		cartHeader.click();
		cartPage cartPage=new cartPage(driver);
		return cartPage;
	}

}
