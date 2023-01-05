package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import Base.Instance;

public class MyExtentReport extends Instance{
	
	public void startReport() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Extent/SwagLabs_ExtentReport.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "Windows");
        extent.setSystemInfo("Environment", "UAT");
        extent.setSystemInfo("User Name", "Pranay Chander");
        extent.setSystemInfo("Application Under Test", "SwagsLabs");
        
       
        spark.config().setDocumentTitle("SwagLabs_ExtentReport");
               // Name of the report
        spark.config().setReportName("SwagLabs_ExtentReport");
               // Dark Theme
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setProtocol(Protocol.HTTPS);
        spark.config().setTimelineEnabled(true);
        spark.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss a");
// It is now possible to select the views and their order. For example: if you want the Dashboard view to be the primary view, followed by Tests, 
//      spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST }).apply();
       
	}
	
	public void endReport() {
		extent.flush();
		
	}
	

}
