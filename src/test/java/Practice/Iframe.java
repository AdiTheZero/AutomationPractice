package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Iframe {
  @Test
  public void iframe() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/iframe");
	  
	  // Switch to the iframe using the frame's id
      driver.switchTo().frame("mce_0_ifr");

      // Clear the existing text and input new text
      WebElement body = driver.findElement(By.id("tinymce"));
      body.clear();
      body.sendKeys("Aditya-kumar");

      // Switch back to the default content
      driver.switchTo().defaultContent();

	  
  }
}
