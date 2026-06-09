package MyProject.SauceDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryPage {
	WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(css = ".inventory_item")
	List<WebElement> productsList;
	
	By ProductsBy = By.cssSelector(".inventory_item");
	
	public List<WebElement> getProductList()
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductsBy));
		
		return productsList;
	}
	
	public void selectProduct(String productName1)
	{		
		WebElement prod = getProductList().stream().filter(p -> p.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName1)).findFirst().orElse(null);
		Assert.assertNotNull(prod, "Product not found: " +productName1);
		prod.findElement(By.cssSelector(".inventory_item_name")).click();
	}
	
	public void addToCart()
	{
		driver.findElement(By.id("add-to-cart")).click();
	}
	
	public void backToProducts()
	{
	    driver.findElement(By.id("back-to-products")).click();
	}
	
	public cartPage goToCart()
	{
		driver.findElement(By.className("shopping_cart_link")).click();
		cartPage CP = new cartPage(driver);
		return CP;
				
	}

}