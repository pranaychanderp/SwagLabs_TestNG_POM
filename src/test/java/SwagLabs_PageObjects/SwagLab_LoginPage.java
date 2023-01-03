package SwagLabs_PageObjects;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class SwagLab_LoginPage {
	
	WebDriver driver;
	
	By Logo = By.className("login_logo");
	By Username_Textbox = By.id("user-name");
	By Password_Textbox = By.id("password");
	By Login_Button = By.id("login-button");
	
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
	}
}
