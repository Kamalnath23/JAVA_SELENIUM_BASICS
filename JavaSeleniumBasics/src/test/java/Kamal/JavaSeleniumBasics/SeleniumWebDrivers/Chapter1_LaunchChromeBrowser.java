package Kamal.JavaSeleniumBasics.SeleniumWebDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Chapter1_LaunchChromeBrowser {
	WebDriver driver;
  @Test
  public void openBrowser() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*"); //Required for Chrome version 111 and above. Also for selenium 4.25+
	  options.addArguments("start-maximized"); //To maximize the browser window
	  // Remove using an existing user-data-dir (locked by running Chrome) which commonly causes crashes
	  // options.addArguments("--user-data-dir=C:/Users/Kamalnath/AppData/Local/Google/Chrome/User Data"); //To use existing Chrome profile

	  // Add some stability flags (safe defaults). Uncomment headless if you want headless execution (CI).
	  // options.addArguments("--headless=new"); // optional: enable headless mode if running in CI without display
	  options.addArguments("--disable-gpu"); // applicable to Windows OS only // disable GPU acceleration 
	  options.addArguments("--no-sandbox"); // Bypass OS security model, required for running as root in Docker
	  options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems in Docker

	  // Setup the correct chromedriver binary using WebDriverManager
	  WebDriverManager.chromedriver().setup();

	  try {
	    driver = new ChromeDriver(options); //Launch Chrome browser with specified options
	    driver.get("https://www.google.com"); //Open Google website
	    System.out.println("Title of the page: " + driver.getTitle()); //Print the title of the page
	  } finally {
	    if (driver != null) {
	     // driver.quit(); //Close the browser to avoid leftover processes
	    }
	  }
  }
}