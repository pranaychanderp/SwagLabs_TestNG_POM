package Screenshot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.Instance;

public class Screenshot extends Instance{

	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()+ ".png");
}
