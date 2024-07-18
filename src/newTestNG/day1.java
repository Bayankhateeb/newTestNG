package newTestNG;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class day1 {
	@AfterTest
	public void lastexecution () {
		
		System.out.println("I will execute last");

		
		
	}
	@AfterSuite
	public void afSuite() {
		System.out.println("I'm the last suite");

		
	}
@Test
	public void Demo () {
		
		System.out.println("Hello");
		Assert.assertTrue(false);
		
		
	}
@Test

public void SecondTest () {
	
	System.out.println("Bye");
	
	
}
}
