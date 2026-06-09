package MyProject.SauceDemo.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		 driver = initializeDriver();
	}
	
	public WebDriver initializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {
			{
				put("credentials_enable_service", false);
				put("profile.password_manager_enabled", false);
			}
		});	
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
