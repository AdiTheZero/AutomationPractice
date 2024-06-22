import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WhatsAppSendApiAutomationTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with the actual path to your chromedriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Wait for a maximum of 10 seconds if any element is not found
    }

    private boolean checkLoggedIn() {
        try {
            return driver.findElement(By.className("_2Uo0Z")).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("User not logged in: " + e.getMessage());
            return false;
        } catch (WebDriverException e) {
            System.out.println("WebDriver Exception: " + e.getMessage());
            return false;
        }
    }

    private void sendMessage(String number, String message) {
        try {
            driver.navigate().to("https://api.whatsapp.com/send?phone=" + number + "&text=" + message.replace(" ", "%20"));
            driver.findElement(By.id("action-button")).click(); // Click SEND Button
            driver.findElement(By.cssSelector("button._2lkdt>span")).click(); // Click SEND Arrow Button
        } catch (WebDriverException e) {
            System.out.println("Error while sending message: " + e.getMessage());
        }
    }

    @Test
    public void testSendMessage() {
        try {
            driver.navigate().to("https://web.whatsapp.com");
            @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Login to WhatsApp Web and Press Enter");
                scanner.nextLine();
                if (checkLoggedIn()) {
                    break;
                }
            }

            String phoneNumber = "7275153278"; // Replace here
            String messageText = "im aditya your text"; // Replace here

            sendMessage(phoneNumber, messageText);

            // Verify that the message is sent by checking the presence of the message in the chat (implement your verification logic)
            // This is an example and may need adjustments based on the actual WhatsApp Web UI structure
            boolean messageSent = driver.getPageSource().contains(messageText);
            Assert.assertTrue(messageSent, "The message was not sent successfully.");
        } catch (WebDriverException e) {
            System.out.println("Test failed due to WebDriver exception: " + e.getMessage());
            Assert.fail("Test failed due to WebDriver exception: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    
    }
}
