package Kamal.JavaSeleniumBasics.NoPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPage_NoPageFactory {
	WebDriver driver;
	//Locators
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By submitButton = By.id("submit");
	
	//constructor
	public LoginPage_NoPageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	//Action methods
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
			
	}
	
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
  
}
