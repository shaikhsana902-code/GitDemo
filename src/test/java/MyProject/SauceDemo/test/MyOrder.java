package MyProject.SauceDemo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.SauceDemo.InventoryPage;
import MyProject.SauceDemo.LoginPage;
import MyProject.SauceDemo.cartPage;
import MyProject.SauceDemo.checkOutPage;

public class MyOrder extends BaseTest {

	String MyProduct = "Sauce Labs Bolt T-Shirt";
	String ExtraProduct = "Sauce Labs Onesie";

	@Test
	public void submitOrder() {

		LoginPage LP = new LoginPage(driver);
		LP.goTo();
		InventoryPage IP = LP.LoginApp();
		IP.selectProduct(MyProduct);
		IP.addToCart();
		IP.backToProducts();
		IP.selectProduct(ExtraProduct);
		IP.addToCart();
		cartPage CP = IP.goToCart();
		CP.removeProduct(ExtraProduct);
		CP.verifyCartCount(1);
		CP.verifyProduct(MyProduct);
		checkOutPage cPage = CP.clickCheckout();
		cPage.checkoutInfo("Husana", "Shaikh", "400706");
		cPage.continueCheckout();
		cPage.finishOrder();
		Assert.assertEquals(cPage.getConfirmationMessage(), "Thank you for your order!");

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String ErrorMassage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
		Assert.assertEquals(ErrorMassage, "Epic sadface: Sorry, this user has been locked out.");

	}

}


/*
 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
 * ChromeDriver(options); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * 
 * driver.get("https://www.saucedemo.com/");
 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
 * driver.findElement(By.id("password")).sendKeys("secret_sauce");
 * driver.findElement(By.id("login-button")).click(); List<WebElement> products
 * = driver.findElements(By.cssSelector(".inventory_item"));
 * System.out.println(products.size()); WebElement prod =
 * products.stream().filter(p ->
 * p.findElement(By.cssSelector(".inventory_item_name")).getText().equals(
 * MyProduct)).findFirst().orElse(null); Assert.assertNotNull(prod,
 * "Product not found");
 * prod.findElement(By.cssSelector(".inventory_item_name")).click();
 * driver.findElement(By.id("add-to-cart")).click();
 * 
 * driver.findElement(By.id("back-to-products")).click(); products =
 * driver.findElements(By.cssSelector(".inventory_item"));
 * 
 * 
 * WebElement prod1 = products.stream().filter(p ->
 * p.findElement(By.cssSelector(".inventory_item_name")).getText().equals(
 * ExtraProduct)).findFirst().orElse(null); Assert.assertNotNull(prod1,
 * "Extra product not found");
 * prod1.findElement(By.cssSelector(".inventory_item_name")).click();
 * driver.findElement(By.id("add-to-cart")).click();
 * driver.findElement(By.className("shopping_cart_link")).click();
 * driver.findElement(By.id("remove-sauce-labs-onesie")).click(); String
 * cartProduct =
 * driver.findElement(By.cssSelector(".inventory_item_name")).getText();
 * Assert.assertEquals(cartProduct, MyProduct);
 * 
 * driver.findElement(By.id("checkout")).click();
 * driver.findElement(By.id("first-name")).sendKeys(firstName);
 * driver.findElement(By.id("last-name")).sendKeys(lastName);
 * driver.findElement(By.id("postal-code")).sendKeys(zipCode); WebDriverWait w =
 * new WebDriverWait(driver, Duration.ofSeconds(5)); WebElement continueBtn =
 * w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart_button"
 * ))); continueBtn.click(); driver.findElement(By.id("finish")).click(); String
 * CM = driver.findElement(By.cssSelector(".complete-header")).getText();
 * Assert.assertEquals(CM, "Thank you for your order!"); System.out.println(CM);
 */
