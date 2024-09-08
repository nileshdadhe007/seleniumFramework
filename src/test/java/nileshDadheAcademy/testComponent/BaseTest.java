package nileshDadheAcademy.testComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import nileshDadheAcademy.pageobject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{ 
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\nileshDadheAcademy\\resources\\GlobalData.properties") ;
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//it will download latest chromedriver version need not to use system.setProperty
			driver =new ChromeDriver();
				
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{//code for firefox driver
		
			
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("WebDriver.edge.driver", "edge.exe");
			driver=new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
