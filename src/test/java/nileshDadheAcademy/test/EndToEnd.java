package nileshDadheAcademy.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import nileshDadheAcademy.pageobject.CheckoutPage;
import nileshDadheAcademy.pageobject.LandingPage;
import nileshDadheAcademy.pageobject.ProductCatolog;
import nileshDadheAcademy.pageobject.cartPage;
import nileshDadheAcademy.pageobject.confirmationPage;
import nileshDadheAcademy.testComponent.BaseTest;

public class EndToEnd extends BaseTest {
		@Test
		public void submitOrder() throws IOException {
			String productName="ZARA COAT 3";
		

			ProductCatolog ProductCatolog = landingPage.loginApplication("nileshdadhe2403@gmail.com", "Malhar@170823");
			
			List<WebElement> products = ProductCatolog.getProductList();
			ProductCatolog.addProductToCart(productName);
			cartPage cartPage=ProductCatolog.goToCartPage();
			boolean match = cartPage.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage CheckoutPage=cartPage.goToCheckout();
			CheckoutPage.selectCountry("india");
			confirmationPage confirmationPage = CheckoutPage.submitOrder();
			String actualMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(actualMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
		}
		
}
