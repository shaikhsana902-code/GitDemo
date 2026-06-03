package MyProject.SauceDemo.test;

import java.time.Duration;
import java.util.List;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MyProject.SauceDemo.LoginPage;
import MyProject.SauceDemo.cataloguePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String MyProduct = "Sauce Labs Bolt T-Shirt";
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");

		options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
			put("credentials_enable_service", false);
			put("profile.password_manager_enabled", false);
		}});

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
		System.out.println(products.size());
		WebElement prod = products.stream().filter(p->p.findElement(By.cssSelector(".inventory_item_name")).getText().equals(MyProduct)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".inventory_item_name")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Husana");
		driver.findElement(By.id("last-name")).sendKeys("Shaikh");
		driver.findElement(By.id("postal-code")).sendKeys("400706");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement continueBtn = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart_button")));
		continueBtn.click();
		driver.findElement(By.id("finish")).click();
		String CM = driver.findElement(By.cssSelector(".complete-header")).getText();
		Assert.assertTrue(CM.equalsIgnoreCase("Thank you for your order!"));
		System.out.println(CM);
		driver.quit();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}

}

//LoginPage LP = new LoginPage(driver);
		//LP.goTo();
		//cataloguePage CP = LP.LoginApp();

