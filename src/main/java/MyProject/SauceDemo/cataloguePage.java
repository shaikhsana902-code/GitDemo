package MyProject.SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class cataloguePage {
	WebDriver driver;

	public cataloguePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}


/*List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
System.out.println(products.size());

WebElement prod = products.stream().filter(p->p.findElement(By.cssSelector(".inventory_item_name")).getText().equals(MyProduct)).findFirst().orElse(null);
prod.findElement(By.cssSelector(".inventory_item_name")).click();
driver.findElement(By.id("add-to-cart")).click();
driver.findElement(By.className("shopping_cart_link")).click();*/