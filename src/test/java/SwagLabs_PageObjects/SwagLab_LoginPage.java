package SwagLabs_PageObjects;



import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import Base.Instance;

public class SwagLab_LoginPage extends Instance {
	
	
	By Logo = By.className("login_logo");
	By Username_Textbox = By.id("user-name");
	By Password_Textbox = By.id("password");
	By Login_Button = By.id("login-button");
	By Error_Msg = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");
	By Photo = By.xpath("//div[@class='peek']");
	
	public SwagLab_LoginPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void Verify_Title() {
		String Actual_Title = driver.getTitle();
		String Expected_Tile = "Swag Labs";
		Assert.assertEquals(Actual_Title, Expected_Tile);
		System.out.println("Title Verification Done");
	}
	
	public void Verify_Logo() throws Throwable {
		WebElement Logo = driver.findElement(By.className("login_logo"));
		File file = Logo.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Logo.png");
		FileHandler.copy(file, destfile);
		
		
	}
	public void Username(String UN) {
		driver.findElement(Username_Textbox).sendKeys(UN);
	}
	
	public void Password(String pwd) {
		driver.findElement(Password_Textbox).sendKeys(pwd);
	}
	
	public void Login() {
		driver.findElement(Login_Button).click();
		String actualURL =driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
			if(actualURL.equalsIgnoreCase(expectedURL)) { 
				System.out.println("User Logged in Succesfully");
			} 
			else { 
				System.out.println(driver.findElement(Error_Msg).getText());
				System.out.println("User Login Failed");
			}		
	}
}
	
	

