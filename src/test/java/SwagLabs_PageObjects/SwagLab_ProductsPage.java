package SwagLabs_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.Instance;

public class SwagLab_ProductsPage extends Instance {
	
	
	By Backpack = By.id("add-to-cart-sauce-labs-backpack");
	By BikeLight = By.id("add-to-cart-sauce-labs-bike-light");
	By BoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	By Jacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
	By Onesie = By.id("add-to-cart-sauce-labs-onesie");
	By RedTshirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	By Sort = By.className("product_sort_container");
	By Side_Menu = By.id("react-burger-menu-btn");
	By Logout = By.id("logout_sidebar_link");
	By Side_Menu_close = By.id("react-burger-cross-btn");
	By CartBadge = By.className("shopping_cart_badge");
	
	public SwagLab_ProductsPage(WebDriver driver) {
		this.driver =driver;
	}
	

	
	public void Product_BikeLight() {
		WebElement bikelight = driver.findElement(BikeLight);
		bikelight.click();
		WebElement Badge = driver.findElement(CartBadge);
		if(Badge.isDisplayed()) {
			System.out.println("Cart is updated");
			}
		}
	public void Product_Backpack() {
		WebElement backpack = driver.findElement(Backpack);
		backpack.click();
		WebElement Badge = driver.findElement(CartBadge);
		if(Badge.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Backpack is added to the cart");
			}	
		}
	public void Product_BoltTshirt() {
		WebElement bolttshirt = driver.findElement(BoltTshirt);
		bolttshirt.click();
		WebElement Badge = driver.findElement(CartBadge);
		if(Badge.isDisplayed()) {
			Assert.assertTrue(true, "Cart is updated");
			}	
		}
	public void Product_Jacket() {
		WebElement jacket = driver.findElement(Jacket);
		jacket.click();
		WebElement Badge = driver.findElement(CartBadge);
		if(Badge.isDisplayed()) {
			Assert.assertTrue(true, "Cart is updated");
			}	
		}
	public void Product_Onesie() {
		WebElement onesie = driver.findElement(Onesie);
		onesie.click();
		WebElement Badge = driver.findElement(CartBadge);
		if(Badge.isDisplayed()) {
			Assert.assertTrue(true, "Cart is updated");
			}	
		}
	public void Product_RedTshirt() {
		WebElement redTshirt = driver.findElement(RedTshirt);
		redTshirt.click();
		WebElement Badge = driver.findElement(CartBadge);
		if(Badge.isDisplayed()) {
			Assert.assertTrue(true, "Cart is updated");
			}	
		}

	public void sort() {
		Select s = new Select(driver.findElement(Sort));
		s.selectByValue("az");
	}
	
	public void side_menu() throws Throwable {
		driver.findElement(Side_Menu).click();
		Thread.sleep(2000);
	}
	
	public void Logout() {
		driver.findElement(Logout).click();
		
	}
	
	public void Side_Menu_close() {
		driver.findElement(Side_Menu_close).click();
	}
}
