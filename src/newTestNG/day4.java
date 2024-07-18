package newTestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	@Parameters ({"URL"})

	@Test
	public void WebLoginHomeLoan (String urlname) {
		
		//selenium
		System.out.println("webloginhomePersonalLoan");
		System.out.println(urlname);

	}
	@Test (groups= {"Smoke"})

public void MobileLoginHomeLoan() {
	
	//Appium
	
		System.out.println("mobileloginhome");

}
	
	
	
	@Test
	public void APILoginHomeLoan() {
		
		//Reset API automation
		System.out.println("APIloginHome");

		
	}
}
