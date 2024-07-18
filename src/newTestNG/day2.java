package newTestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
@Test (groups= {"Smoke"})
	public void test2 ( ) {
		
		
		System.out.println("good");
		
	}
@BeforeTest

public void prerequiste() {
	
	
	System.out.println("I will exceute first");

	
	
}
}
