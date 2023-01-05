package Browsers;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Base.Instance;

public class MyBrowser extends Instance {
		
		
		public MyBrowser(WebDriver driver) {
			this.driver =driver;
		}
		

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
			
			driver.manage().window().maximize();
			driver.get(property.getProperty("URL"));
		}	
		
		public void tearDown() throws Exception {
			driver.quit();
			
		}
	
}
