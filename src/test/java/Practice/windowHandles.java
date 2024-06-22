
package Practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class windowHandles {
	 private static final Logger logger = LoggerFactory.getLogger(windowHandles.class);
	
  @Test
  public void f() throws InterruptedException {
	  
	
	  WebDriver driver = new ChromeDriver();
	  driver.get("  https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
	  driver.switchTo().frame("myframe");
	 WebElement para= driver.findElement(By.xpath("//body/div[contains(text(),'Simple page with simple test.')]"));
	 String para2= para.getText();
     System.out.println(para2);
     String parentWindow = driver.getWindowHandle();
     System.out.println(parentWindow);
     assertNotNull(parentWindow,"ok this is parent window");
     
     driver.switchTo().defaultContent();
     
     //click on link to open a new window
     driver.findElement(By.linkText("Open new window")).click();
     
     
     //fetch handles of all windows, there will be two, [0]- default, [1] - new window
     Object[] windowHandles=driver.getWindowHandles().toArray();
     driver.switchTo().window((String) windowHandles[1]);
    
     
     Thread.sleep(5000);
     //assert on title of new window
     String title=driver.getTitle();
     assertEquals("Simple Page",title);
     System.out.println(title);
     
     driver.close();
     
     driver.switchTo().window(parentWindow);
     String mainTitle =driver.getTitle();
    // assertEquals("Test page for WindowSwitchingTest.testShouldFocusOnTheTopMostFrameAfterSwitchingToAWindow", mainTitle);
     // Perform a hard assertion with logging
     try {
         assertEquals(mainTitle, "Test page for WindowSwitchingTest.testShouldFocusOnTheTopMostFrameAfterSwitchingToAWindow");
         logger.info("Assertion passed: Expected Title for Parent Window");
         
     } catch (AssertionError e) {
         logger.error("Assertion failed: Expected Title 1 but found " + mainTitle, e);
         throw e;
     }
     System.out.println(mainTitle);
     driver.close();
    
  
  }
}
