package Kamal.JavaSeleniumBasics.SeleniumBasicConcepts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Chapter9_KeywordActions {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize(); // Maximize the browser window
		driver.get("https://demoqa.com/text-box"); // Open Bing website
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  
  @Test
  public void performKeywordActions() {
	  System.out.println("Title of the page: " + driver.getTitle()); // Print the title of the page
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement txtFullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
	  //Scroll and click java script to avoid iframe issues
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", txtFullName); // Scroll to the element
	  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // Pause for half a second
//	  JavascriptExecutor js2 = (JavascriptExecutor) driver;
//	  js2.executeScript("arguments[0].click();", txtFullName); // Click the element and focus
	  txtFullName.click();
	  //Actions class to perform keyboard actions
	  Actions actions = new Actions(driver);
	  //Type full name in uppercase using SHIFT key
	  actions.keyDown(Keys.SHIFT) //press SHIFT key
	  	   .sendKeys("kakorat")
	  	   .keyUp(Keys.SHIFT) //release SHIFT key
	  	   .build().perform();
	  System.out.println("Full name entered in uppercase using keyboard actions.");
	  
	  //Select all the text and copy it using  ctrlm A and ctrl C
	  actions.keyDown(Keys.CONTROL)
	  	   .sendKeys("a") //Select all
	  	   .sendKeys("c") //Copy
	  	   .keyUp(Keys.CONTROL)
	  	   .build().perform();
	  System.out.println("Full name text selected and copied using keyboard actions.");
	  
	  //Press TAB to move to the next field (Email field)
	  actions.sendKeys(Keys.TAB).build().perform();
	  System.out.println("Pressed TAB to move to the next field.");
	  //Paste the copied text into the Email field using ctrl V
	  actions.keyDown(Keys.CONTROL)
	  	   .sendKeys("v") //Paste
	  	   .keyUp(Keys.CONTROL)
	  	   .build().perform();
	  System.out.println("Pasted the copied text into the Email field using keyboard actions.");
	  
	  
  }

}
