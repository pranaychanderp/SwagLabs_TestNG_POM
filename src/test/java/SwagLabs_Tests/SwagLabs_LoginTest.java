package SwagLabs_Tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Instance;
import Browsers.MyBrowser;
import Reports.MyExtentReport;
import ScreenRecording.MyScreenRecorder;
import SwagLabs_PageObjects.SwagLab_LoginPage;
import SwagLabs_PageObjects.SwagLab_ProductsPage;

public class SwagLabs_LoginTest extends Instance{
	
	@BeforeTest
	public void OpenReport() {
		MyExtentReport report = new MyExtentReport();
		report.startReport();
	}
	
	@BeforeMethod
	public void StartBrowser() throws Throwable {
//		MyScreenRecorder.startRecording("SwagLabs TestCases");
		MyBrowser browser = new MyBrowser(driver);
		browser.Setup();
	}	
	@Test(invocationCount = 1)
	public void LoginTest() throws Throwable {
		
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);
		driver.manage().window().maximize();
		driver.get(property.getProperty("URL"));
		SwagLab_LoginPage Login = new SwagLab_LoginPage(driver);
		logger = extent.createTest("SwagLabs Login Test with Valid credentials");
		Login.Username(property.getProperty("username"));
		logger.info("Username is "+property.getProperty("username"));
		Login.Password(property.getProperty("password"));
		logger.info("Password is "+property.getProperty("password"));
		Login.Login();
		logger.createNode("Logged In Susccesfully");
		logger.assignAuthor("Praveen Palarapu");
		logger.assignCategory("Login");
		logger.assignDevice("Windows 11");
		
	}
	
	@Test(invocationCount = 1)
	public void InvalidLoginTest() throws Throwable {
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);
		driver.manage().window().maximize();
		driver.get(property.getProperty("URL"));
		SwagLab_LoginPage Login = new SwagLab_LoginPage(driver);
		logger = extent.createTest("SwagLabs Login Test with invalid credentials");
		Login.Username(property.getProperty("username1"));
		logger.info("Username is "+property.getProperty("username1"));
		Login.Password(property.getProperty("password1"));
		logger.info("Password is "+property.getProperty("password1"));
		Login.Login();
		logger.createNode("Not Logged In Susccesfully");
		logger.assignAuthor("Pranay Palarapu");
		logger.assignCategory("Login");
		logger.assignDevice("Windows 10");
		
//		logger.addScreenCast("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\SwagLabs TestCases-2023-01-05 13.35.45.avi","Invalid Login");
	}
	
	@Test(invocationCount = 1)
	public void Verify_Logo() throws Throwable {
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);
		driver.manage().window().maximize();
		driver.get(property.getProperty("URL"));
		SwagLab_LoginPage logo = new SwagLab_LoginPage(driver);
		logger = extent.createTest("SwagLabs Logo Verification Test");
		logo.Verify_Logo();
		boolean Logo1 = driver.findElement(By.className("login_logo")).isDisplayed();
		if (Logo1) {
			logger.createNode("Image is Present");
			Assert.assertTrue(Logo1);
			logger.addScreenCaptureFromPath("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Logo.png","Logo");
		}
		else {
			logger.createNode("Image is not Present");
			Assert.assertFalse(Logo1);
		}
		logger.createNode("Logo Verification Done");
		logger.assignAuthor("Likitha Palarapu");
		logger.assignCategory("Logo");
		logger.assignDevice("Windows 10");
	}
	@Test(invocationCount = 1)
	public void Verify_Title() throws Throwable {
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);
		driver.manage().window().maximize();
		driver.get(property.getProperty("URL"));
		SwagLab_LoginPage title = new SwagLab_LoginPage(driver);
		logger = extent.createTest("SwagLabs Title Verification Test");
		title.Verify_Title();
		logger.createNode("Title Verification Done");
		logger.assignAuthor("Rajini Palarapu");
		logger.assignCategory("Title");
		logger.assignDevice("Windows 11");
	}
	
	@Test
	public void LogoutTest() throws Throwable {
		
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);
		driver.manage().window().maximize();
		driver.get(property.getProperty("URL"));
		SwagLab_LoginPage Login = new SwagLab_LoginPage(driver);
		logger = extent.createTest("SwagLabs Logout Test");
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
		logger.createNode("Logged out Susccesfully");
		logger.assignAuthor("Rajini Palarapu");
		logger.assignCategory("Logout");
		logger.assignDevice("Windows 11");
	}
	
	@AfterMethod
	public void EndBrowser() throws Exception {
		MyBrowser browser = new MyBrowser(driver);
		browser.tearDown();
		
//		MyScreenRecorder.stopRecording();
	}
	
	@AfterTest
	public void CloseReport() {
		MyExtentReport report = new MyExtentReport();
		report.endReport();
	}
	
}

	

