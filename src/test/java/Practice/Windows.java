package Practice;

import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Windows {
  @Test
  public void multipleWindows() {
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/windows");
	  driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
	  String pwindonw= driver.getWindowHandle();
	  Set<String> windowIds= driver.getWindowHandles();
	  for(String windowId : windowIds)
	  {
		  driver.switchTo().window(windowId);
		  try {
			  String text = driver.findElement(By.tagName("h3")).getText();
			  System.out.println(text);
			  
			  driver.quit();
		  }
		  catch(NoSuchElementException e)
		  {
			  driver.close();
		  }
		  
	  }
	  
	  
  }
}
