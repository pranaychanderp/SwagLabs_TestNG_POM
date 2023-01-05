package SwagLabs_Tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import Base.Instance;
import Browsers.MyBrowser;
import Reports.MyExtentReport;
import SwagLabs_PageObjects.SwagLab_LoginPage;
import SwagLabs_PageObjects.SwagLab_ProductsPage;
import SwagLabs_PageObjects.SwagLabs_CartPage;
import SwagLabs_PageObjects.SwagLabs_CheckOutPage;

public class SwagLabs_PlacingOrder extends Instance {
	
	@Test
	public void Order() throws Throwable {
		MyExtentReport report = new MyExtentReport();
		report.startReport();
		MyBrowser browser = new MyBrowser(driver);
		browser.Setup();
		Properties property = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\Pranay Chander P\\git\\SwagLabs_TestNG_POM\\Properties\\Config.properties");
		property.load(File);
		SwagLab_LoginPage Login = new SwagLab_LoginPage(driver);
		logger = extent.createTest("Placing an order in SwagLabs");
		Login.Username(property.getProperty("username"));
		logger.info("Username is "+property.getProperty("username"));
		Login.Password(property.getProperty("password"));
		logger.info("Password is "+property.getProperty("password"));
		Login.Login();
		SwagLab_ProductsPage product = new SwagLab_ProductsPage(driver);
		Thread.sleep(3000);
		product.Product_Backpack();
		logger.info("Backpack product added to the cart");
		SwagLabs_CartPage cart =new SwagLabs_CartPage(driver);
		cart.ClickOnCart();
		cart.CheckOut();
		SwagLabs_CheckOutPage checkout = new SwagLabs_CheckOutPage(driver);
		checkout.CheckoutDetails();
		product.side_menu();
		product.Logout();
		browser.tearDown();
		report.endReport();
	}
}
