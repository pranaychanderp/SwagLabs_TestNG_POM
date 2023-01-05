package SwagLabs_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.Instance;

public class SwagLabs_CartPage extends Instance{
	

	
	By Cart = By.xpath("//div[@id='shopping_cart_container']");
	By Continue_Shopping = By.xpath("//button[@id='continue-shopping']");
	By CheckOut = By.xpath("//button[@id='checkout']");

	public SwagLabs_CartPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void ClickOnCart() {
		driver.findElement(Cart).click();
	}
	
	public void Continue_Shopping() {
		driver.findElement(Continue_Shopping).click();
	}
	
	public void CheckOut() {
		driver.findElement(CheckOut).click();
	}
}
