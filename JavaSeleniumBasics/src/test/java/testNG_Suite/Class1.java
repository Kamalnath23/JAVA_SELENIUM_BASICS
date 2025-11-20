package testNG_Suite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Class1 {
  @Test
  public void test() {
	  System.out.println("This is TestNG Suite Class1");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method Class1");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method Class1");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class Class1");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Class Class1");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test Class1");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test Class1");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite Class1");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite Class1");
  }

}
