package SwagLabs_Tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SwagLabs_PageObjects.SwagLab_LoginPage;
import SwagLabs_PageObjects.SwagLab_ProductsPage;

public class SwagLabs_LogoutTest {
	private WebDriver driver;
	
	@BeforeTest
	public void Setup() throws Throwable {
		
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);
		String browser_name = (property.getProperty("browser"));
		if (browser_name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", property.getProperty("driver_chrome"));
			driver = new ChromeDriver();
		}
		else if (browser_name.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.egde.driver",property.getProperty("driver_edge"));
			driver = new EdgeDriver();
		}
		else if (browser_name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver",property.getProperty("driver_firefox"));
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Browser not Found");
		}
	}	
	@Test
	public void Login() throws Throwable {
		
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);

		driver.manage().window().maximize();
		driver.get(property.getProperty("URL"));
		
		SwagLab_LoginPage Login = new SwagLab_LoginPage(driver);
		Login.Verify_Title();
		Login.Verify_Logo();
		Login.Username(property.getProperty("username"));
		Login.Password(property.getProperty("password"));
		Login.Login();
		System.out.println("Logged In Susccesfully");
		Thread.sleep(3000);
		SwagLab_ProductsPage Logout = new SwagLab_ProductsPage(driver);
		Logout.side_menu();
		Logout.Logout();
		System.out.println("Logged out Susccesfully");
	}
	
	@AfterTest
	public void Teardown() {
		driver.close();
	}
	
}
