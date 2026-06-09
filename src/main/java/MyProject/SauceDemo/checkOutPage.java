package MyProject.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class checkOutPage {
	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	By continueBtn = By.cssSelector(".cart_button");
	By finishBtn = By.id("finish");
	By confirmationMsg = By.cssSelector(".complete-header");

	public void checkoutInfo(String fname, String lname, String zip) {
		driver.findElement(firstName).sendKeys(fname);

		driver.findElement(lastName).sendKeys(lname);

		driver.findElement(postalCode).sendKeys(zip);

	}
	
	public void continueCheckout()
	{
		driver.findElement(continueBtn).click();
	}
	
	public void finishOrder()
	{
	    driver.findElement(finishBtn).click();
	}
	
	public String getConfirmationMessage()
	{
	    return driver.findElement(confirmationMsg).getText();
	}
}

/*
 * driver.findElement(By.id("first-name")).sendKeys(firstName);
 * driver.findElement(By.id("last-name")).sendKeys(lastName);
 * driver.findElement(By.id("postal-code")).sendKeys(zipCode); WebDriverWait w =
 * new WebDriverWait(driver, Duration.ofSeconds(5)); WebElement continueBtn =
 * w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart_button"
 * ))); continueBtn.click(); driver.findElement(By.id("finish")).click(); String
 * CM = driver.findElement(By.cssSelector(".complete-header")).getText();
 * Assert.assertEquals(CM, "Thank you for your order!"); System.out.println(CM);
 */