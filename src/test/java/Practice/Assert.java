package Practice;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert.*;

public class Assert {
	//Assertion in tesNG are used for validating the test methods 
	//and to verfiy that the expected result and the actual result method or not
	// there are 2 types -->hard and soft 
	//-------------------------------------------------------------------------------------
	// HARD ASSERTION --> AssertEquals-->Assert.assertEquals(actual,expected,message)
	//AssertNOTEqual--> AssertNOTEqual(actual,expected,message)
	//AssertTrue-->Assert.AssertTrue(condition)
	//AssertFalse--->Assert.AssertFalse(condition)
	//--------------------------------------------------------------------------------------
	
  @Test
  public void Asserttest() {
	  WebDriver driver = new ChromeDriver();
	  SoftAssert soft=new SoftAssert();
	  
//	  driver.get("https://www.google.com");
//	  String actualTitle=driver.getTitle();
//	  String expectedTitle= "Google";
//	//  String message = "Strings are not equal!";
//	  // Corrected order: actual first, expected second
////      Assert.assertEquals(actualTitle, expectedTitle, message);
//	 assertEquals(actualTitle, expectedTitle,"ok title");
//	 
//	 WebElement input= driver.findElement(By.id("APjFqb"));
//	 assertTrue(input.isDisplayed(),"ok");
    // assertTrue(input);
	 
	 //------------------------------------------
	  driver.get("https://www.google.com");
	  String actualTitle=driver.getTitle();
	  String expectedTitle= "Goole";
	//  String message = "Strings are not equal!";
	  // Corrected order: actual first, expected second
//      Assert.assertEquals(actualTitle, expectedTitle, message);
	 soft.assertEquals(actualTitle, expectedTitle,"ok title");
	 
	 WebElement input= driver.findElement(By.id("APjFqb"));
	 soft.assertTrue(input.isDisplayed(),"ok");
	
	 
	 driver.close();
	 soft.assertAll();
	  
  }
}
