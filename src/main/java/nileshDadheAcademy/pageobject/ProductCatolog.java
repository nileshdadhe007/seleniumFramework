package nileshDadheAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nileshDadheAcademy.AbstractComponent.AbstractComponent;

public class ProductCatolog extends AbstractComponent{
	WebDriver driver;
	
	 public ProductCatolog(WebDriver driver) 
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	//	List<WebElement> products = driver.findElements(By.className("col-lg-4"));
	@FindBy(className="col-lg-4") 
	List<WebElement> products;
	@FindBy(className="ng-animating")
	WebElement spinner;
	
	By productsby =By.className("col-lg-4");
	By addToCart=By.xpath("//button[2]");
	By toastMessage=By.id("toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsby);
		return products;
		
	}
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
	 
}
