package Practice;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ScreenShot {
  @Test
  public void f() {
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("headless");
	 
	  
	  WebDriver driver = new ChromeDriver(options);
	  
	  driver.get("https://www.google.co.in/");
	  
	  TakesScreenshot ts = ((TakesScreenshot)driver);
	File scre=  ts.getScreenshotAs(OutputType.FILE);
	   // Format the timestamp to avoid invalid characters in the filename
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
    String timestamp = LocalDateTime.now().format(formatter);
	  try {
		  var folderPath = new File("src\\screenshot");
		  System.out.println(folderPath.getAbsolutePath());
		  FileUtils.cleanDirectory(folderPath);
          FileUtils.copyFile(scre, new File("src\\screenshot\\screenshot_"+timestamp+ ".png"));
        
      } catch (IOException e) {
          System.out.print("Error while taking screenshot: " + e);
      }
	  
	  
	  driver.close();
	  
  }
}
