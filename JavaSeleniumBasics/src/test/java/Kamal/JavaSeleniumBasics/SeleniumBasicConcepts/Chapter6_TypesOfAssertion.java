package Kamal.JavaSeleniumBasics.SeleniumBasicConcepts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Chapter6_TypesOfAssertion {
  @Test
  public void TypesOfSoftAssertion() {
	  SoftAssert softAssert = new SoftAssert();
	  //Types of Soft Assertions in TestNG
	  //1. assertEquals(actual, expected, message) - Verifies that two values are
	  //   equal. If not, it records a failure with the provided message.
	  String expectedTitle = "Google";
	  String actualTitle = "Google";
	  softAssert.assertEquals(actualTitle, expectedTitle, "Title does not match for Google");
	  
	  //2. assertNotEquals(actual, expected, message) - Verifies that two values
	  //   are not equal. If they are equal, it records a failure with the provided
	  //   message.
	  String unexpectedTitle = "Bing";
	  softAssert.assertNotEquals(actualTitle, unexpectedTitle, "Title should not match Bing");
	  
	  //3. assertTrue(condition, message) - Verifies that a condition is true.
	  //   If the condition is false, it records a failure with the provided message.
	  boolean isTitleDisplayed = true; // Example condition
	  softAssert.assertTrue(isTitleDisplayed, "Title is not displayed as expected");
	  
	  //4. assertFalse(condition, message) - Verifies that a condition is false.
	  //   If the condition is true, it records a failure with the provided message.
	  boolean isTitleHidden = false; // Example condition
	  softAssert.assertFalse(isTitleHidden, "Title is unexpectedly hidden");
	  
	  //5. assertNull(object, message) - Verifies that an object is null.
	  //   If the object is not null, it records a failure with the provided message.
	  Object titleObject = null; // Example object
	  softAssert.assertNull(titleObject, "Title object is not null");
	  
	  //6. assertNotNull(object, message) - Verifies that an object is not null.
	  //   If the object is null, it records a failure with the provided message.
	  Object nonNullTitleObject = new Object(); // Example object
	  softAssert.assertNotNull(nonNullTitleObject, "Title object is null");
	  
	  //Collate all assertions and report any failures
	  softAssert.assertAll();
	  
	  //7. Assert same(object1, object2, message) - Verifies that two references point
	  //   to the same object. If they do not, it records a failure with the
	  //   provided message.
	  Object obj1 = nonNullTitleObject;
	  Object obj2 = nonNullTitleObject;
	  softAssert.assertSame(obj1, obj2, "Objects do not reference the same instance"
	  		+ "");
	  //8. Assert notSame(object1, object2, message) - Verifies that two references
	  //   do not point to the same object. If they do, it records a failure
	  //   with the provided message.
	  Object obj3 = new Object();
	  softAssert.assertNotSame(obj1, obj3, "Objects reference the same instance");
	  softAssert.assertAll();
	  
	  //Assert Fail
	  //9. fail(message) - Immediately records a failure with the provided message.
	  //   This is useful for marking a test as failed under certain conditions.
	  //   Note: This method does not take a condition; it simply fails the test.
	  //   Uncomment the line below to see it in action.
	  //softAssert.fail("This is a forced failure for demonstration purposes.");
	  
	  
  }
}
