package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.navigate().to("https://the-internet.herokuapp.com/upload");
	  driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Aditya\\Downloads\\Aditya's Resume (4).pdf");
	  driver.findElement(By.xpath("//input[@id='file-submit']")).click();
	  Thread.sleep(3000);
	  driver.close();
  }
}
