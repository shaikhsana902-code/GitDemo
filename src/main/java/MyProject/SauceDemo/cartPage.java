package MyProject.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class cartPage {
	WebDriver driver;

	public cartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	By cartProductName = By.cssSelector(".inventory_item_name");
	By checkoutBtn = By.id("checkout");

	public void verifyProduct(String expectedProduct) {
		String actualProduct = driver.findElement(cartProductName).getText();
		System.out.println(actualProduct);
		Assert.assertEquals(actualProduct, expectedProduct);

	}

	public void removeProduct(String productName) {
		driver.findElement(By.id("remove-sauce-labs-onesie")).click();
	}
	
	public checkOutPage clickCheckout()
	{
	    driver.findElement(checkoutBtn).click();
	    checkOutPage cPage = new checkOutPage(driver);
	    return cPage;
	    		
	}
	public void verifyCartCount(int expectedCount)
	{
	    Assert.assertEquals(
	        driver.findElements(cartProductName).size(),
	        expectedCount);
	}
}

/*
 * driver.findElement(By.id("remove-sauce-labs-onesie")).click(); String
 * cartProduct =
 * driver.findElement(By.cssSelector(".inventory_item_name")).getText();
 * Assert.assertEquals(cartProduct, MyProduct);
 * 
 * driver.findElement(By.id("checkout")).click();
 */