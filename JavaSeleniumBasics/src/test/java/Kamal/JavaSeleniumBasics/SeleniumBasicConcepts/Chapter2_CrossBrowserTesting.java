package Kamal.JavaSeleniumBasics.SeleniumBasicConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chapter2_CrossBrowserTesting {
	WebDriver driver;
  @Test
  public void openEdge() {
	  System.out.println("Launching Edge browser");
	  try {
		  //Attempt to setup and launch Edge browser
	    WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver(); //Launch Edge browser
	    driver.manage().window().maximize(); //Maximize the browser window
	    driver.get("https://www.bing.com"); //Open Bing website
	    System.out.println("Title of the page: " + driver.getTitle()); //Print the
	  }catch(Exception e) {
		  System.out.println("Error launching Edge browser: " + e.getMessage());
	  }finally {
	    if (driver != null) {
	     // driver.quit(); //Close the browser to avoid leftover processes
	    }
	  }
  }
  
  @Test
  public void openFirefox() {
	  System.out.println("Launching Firefox browser");
	  try {
		  //Attempt to setup and launch Firefox browser
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver(); //Launch Firefox browser
	    driver.manage().window().maximize(); //Maximize the browser window
	    driver.get("https://www.duckduckgo.com"); //Open DuckDuckGo website
	    System.out.println("Title of the page: " + driver.getTitle()); //Print the
	  }catch(Exception e) {
		  System.out.println("Error launching Firefox browser: " + e.getMessage());
	  }finally {
	    if (driver != null) {
	     // driver.quit(); //Close the browser to avoid leftover processes
	    }
	  }
  }
  
  @Test
  public void openChrome() {
	  System.out.println("Launching Chrome browser");
	  try {
		  //Attempt to setup and launch Chrome browser
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*"); //Required for Chrome version 111 and above. Also for selenium 4.25+
	    options.addArguments("start-maximized"); //To maximize the browser window
	    //options.addArguments("--user-data-dir=C:/Program Files (x86)/Google/Chrome/Temp"); //To use existing Chrome profile
	    driver = new ChromeDriver(options); //Launch Chrome browser with specified options
	    driver.get("https://www.google.com"); //Open Google website
	    System.out.println("Title of the page: " + driver.getTitle()); //Print the title of the page
	    
	    //future use
	    /**
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    options.addArguments("start-maximized");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-gpu");
	    options.addArguments("--incognito"); // optional for fresh session

	    WebDriver driver = new ChromeDriver(options);
	    **/

	  }catch(Exception e) {
		  System.out.println("Error launching Chrome browser: " + e.getMessage());
	  }finally {
	    if (driver != null) {
	     // driver.quit(); //Close the browser to avoid leftover processes
	    }
	  }
  }	
}
