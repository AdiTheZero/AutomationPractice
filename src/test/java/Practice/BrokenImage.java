package Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenImage {
	
	 ChromeDriver drive;
  @Test
  public void brokenImage() {
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/broken_images");
	  
	  List<WebElement> images = driver.findElements(By.tagName("img"));//a tag for broken link
	  for (WebElement img : images) {
          String imgUrl = img.getAttribute("src");//href
          if (isImageBroken(imgUrl)) {
              System.out.println("Broken image found: " + imgUrl);
          } else {
              System.out.println("Valid image found: " + imgUrl);
          }
      }
  }

  public boolean isImageBroken(String imgUrl) {
      try {
          HttpURLConnection connection = (HttpURLConnection) (new URL(imgUrl).openConnection());
//          connection.setRequestMethod("GET");
          connection.connect();
          int responseCode = connection.getResponseCode();
          connection.disconnect();
          return responseCode != 200;
      } catch (Exception e) {
          e.printStackTrace();
          return true;
      }
      
  }
  
  
  public void tearDown() {
      // Close the browser
      if (drive != null) {
          drive.quit();
      }
  }
 
}
