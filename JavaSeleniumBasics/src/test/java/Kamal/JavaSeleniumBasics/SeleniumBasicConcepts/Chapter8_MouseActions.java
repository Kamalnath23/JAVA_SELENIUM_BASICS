package Kamal.JavaSeleniumBasics.SeleniumBasicConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chapter8_MouseActions {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize(); // Maximize the browser window
		driver.get("https://demo.guru99.com/test/simple_context_menu.html"); 
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
  @Test(priority=0)
  public void doubleClick() {
	  WebElement btnDoubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
	  Actions actions = new Actions(driver);
	  actions.doubleClick(btnDoubleClick).perform();
	  System.out.println("Double click action performed.");
	  
	  // Handle the alert
	  Alert alert = driver.switchTo().alert();
	  System.out.println("Alert text: " + alert.getText());
	 
	  
	  //Assert the alert text
	  Assert.assertEquals(alert.getText(), "You double clicked me.. Thank You..");
	  
	  alert.accept(); // Accept the alert
  }
  
  @Test(priority=1)
  public void rightClick() {
	  WebElement btnRightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
	  Actions actions = new Actions(driver);
	  actions.contextClick(btnRightClick).perform();
	  System.out.println("Right click action performed.");
	  
	  // Click on the 'Edit' option from the context menu
	  WebElement editOption = driver.findElement(By.xpath("//span[text()='Edit']"));
	  editOption.click();
	  
	  // Handle the alert
	  Alert alert = driver.switchTo().alert();
	  System.out.println("Alert text: " + alert.getText());
	  
	  //Assert the alert text
	  Assert.assertEquals(alert.getText(), "clicked: edit");
	  
	  alert.accept(); // Accept the alert
	  
	  //keyboard action of moving down
	  actions.contextClick(btnRightClick)
	  .sendKeys(Keys.ARROW_DOWN)
	  .sendKeys(Keys.ARROW_DOWN)
	  .sendKeys(Keys.ENTER).build().perform();
	  
	  System.out.println("Right click with keyboard action performed.");
	  
	  // Handle the alert
	  Alert alert2 = driver.switchTo().alert();
	  System.out.println("Alert text: " + alert2.getText());
	  Assert.assertEquals(alert2.getText(), "clicked: cut");
	  alert2.accept(); // Accept the alert
	  
  }
}
