package MyProject.SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user-name")
	WebElement email;
	@FindBy(id = "password")
	WebElement pass;
	@FindBy(id = "login-button")
	WebElement login;

	public InventoryPage LoginApp() {
		email.sendKeys("standard_user");
		pass.sendKeys("secret_sauce");
		login.click();
		
		InventoryPage IT = new InventoryPage(driver);
		return IT;

	}
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}

}

/*
 * driver.get("https://www.saucedemo.com/");
 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
 * driver.findElement(By.id("password")).sendKeys("secret_sauce");
 * driver.findElement(By.id("login-button")).click();
 */