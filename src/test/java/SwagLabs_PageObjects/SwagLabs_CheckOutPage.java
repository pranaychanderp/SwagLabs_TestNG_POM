package SwagLabs_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.Instance;

public class SwagLabs_CheckOutPage extends Instance {
	
	By Fname = By.id("first-name");
	By Lname = By.id("last-name");
	By Zipcode = By.id("postal-code");
	By Continue = By.id("continue");
	By Finish = By.id("finish");
	
	public SwagLabs_CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void CheckoutDetails() {
		boolean Text1 = driver.findElement(By.xpath("//span[text()='Checkout: Your Information']")).isDisplayed();
		Assert.assertTrue(Text1);
		if (Text1) {
			driver.findElement(Fname).sendKeys("Test");
			driver.findElement(Lname).sendKeys("Test2");
			driver.findElement(Zipcode).sendKeys("123456");
			driver.findElement(Continue).click();
			boolean Text2 = driver.findElement(By.xpath("//span[text()='Checkout: Overview']")).isDisplayed();
			Assert.assertTrue(Text2);
			if (Text2) {
				driver.findElement(Finish).click();
				boolean Text3 = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']")).isDisplayed();
				Assert.assertTrue(Text3);
			}
		}
	}
}
