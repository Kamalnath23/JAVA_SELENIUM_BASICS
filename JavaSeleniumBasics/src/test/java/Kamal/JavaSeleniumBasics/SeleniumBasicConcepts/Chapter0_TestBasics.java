package Kamal.JavaSeleniumBasics.SeleniumBasicConcepts;

import org.testng.annotations.Test;

public class Chapter0_TestBasics {
	//Test Annotation in TestNG is used to mark a method as a test method.
	//When you run the test suite, TestNG will execute all methods annotated with @Test.
	//This allows you to define test cases in your code that can be executed independently.
  @Test
  public void BasicTest() {
	  System.out.println("This is a basic test");
  }
}
