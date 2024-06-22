package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts {
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
	  driver.findElement(By.xpath("//div/button[contains(text(),'Alert')]")).click();
	  Thread.sleep(3000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("(//div/button[contains(text(),'Click Me')])[2]")).click();
	  Thread.sleep(3000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("(//div/button[contains(text(),'Click Me')])[3]")).click();
	  Thread.sleep(3000);
	  driver.switchTo().alert().sendKeys("Aditya--Kumar");
	  Thread.sleep(3000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
	  driver.close();
  }
}
