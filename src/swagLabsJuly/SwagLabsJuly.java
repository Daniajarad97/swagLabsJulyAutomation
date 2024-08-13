package swagLabsJuly;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwagLabsJuly {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setup() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginTest() {
		String UserName = "standard_user";
		String Password = "secret_sauce";

		WebElement UserNameLogin = driver.findElement(By.id("user-name"));
		WebElement PasswordLogin = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameLogin.sendKeys(UserName);
		PasswordLogin.sendKeys(Password);
		LoginButton.click();

	}

	@Test(priority = 2)
	public void addToCartAllItems() {
		// Loop to add the first 4 items to cart then stop

		List<WebElement> AddToCartButton = driver.findElements(By.className("btn"));

		for (int index = 0; index < AddToCartButton.size(); index++) {

			if (index == 4) {
				break;
			} else {
				AddToCartButton.get(index).click();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		WebElement ShoppingCart = driver.findElement(By.id("shopping_cart_container"));
		ShoppingCart.click();
	}

	@Test(priority = 3)
	public void removeAllItemsFromCart() {
		// Loop to remove the items to the cart

		List<WebElement> removeItems = driver.findElements(By.className("btn_small"));
		for (int index = 0; index < removeItems.size(); index++) {
			if (index == 2) {
				break;
			} else {
				removeItems.get(index).click();
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		WebElement ContinueShopping = driver.findElement(By.id("continue-shopping"));
		ContinueShopping.click();
	}
}
