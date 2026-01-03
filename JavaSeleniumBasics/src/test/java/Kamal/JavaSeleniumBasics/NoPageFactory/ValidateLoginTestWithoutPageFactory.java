package Kamal.JavaSeleniumBasics.NoPageFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ValidateLoginTestWithoutPageFactory {
WebDriver driver;
  @Test
  public void ValidateLoginTest() {
	  driver = Utility.openBrowser("edge", "https://practicetestautomation.com/practice-test-login/");
	  LoginPage_NoPageFactory loginPage = new LoginPage_NoPageFactory(driver);
	  loginPage.enterUsername("student");
	  loginPage.enterPassword("Password123");
	  loginPage.clickSubmit();
	  
	  String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
	  if (driver.getCurrentUrl().equals(expectedUrl)) {
		  System.out.println("Login Test without Page Factory executed successfully.");
	  } else {
		  System.out.println("Login Test without Page Factory failed.");
	  }
  }
}
