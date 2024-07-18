package newTestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class day3 {

	
	@AfterClass
	public void afterClass () {
		
		System.out.println("After execiting any methods in the class ");

	}
	
	@BeforeSuite 
	public void bfSuite() {
		System.out.println("I'm the first suite ");

		
	}
	@BeforeMethod
	public void beforeevery() {
		System.out.println("I will execute before any test in day3 class");

		
		
	}
	
	@BeforeClass
	
	public void BeforeClass () {
		
		System.out.println("Before execiting any methods in the class ");

	}
	
	@AfterMethod
	public void afterevery() {
		System.out.println("I will execute after any test in day3 class");

		
		
	}
	@Parameters ({"URL" , "APIKey/usrname"})

 // delay for response need time to execution (timeOut = 4000)

		public void WebLoginCarLoan (String urlname , String key) {

			//selenium
			System.out.println("weblogincar");
			System.out.println(urlname);
			System.out.println(key);

		}

		@Test(enabled = false) //not be executed 
	public void MobileLoginCarLoan() {
		
		//Appium
		
			System.out.println("mobilelogincar");

	}
		@Test (dataProvider = "getData")
		public void provideData(String username , String passwoard) {
			
			//Appium
			
				System.out.println("get all data :");
				System.out.println(username);
				System.out.println(passwoard);

		}
		@Test (groups= {"Smoke"})

		public void MobileSignupCarLoan() {
			
			//Appium
			
				System.out.println("mobile Signup car");

		}
		
		
		@Test(dependsOnMethods= {"WebLoginCarLoan" })
		public void APILCarLoan() {
			
			//Reset API automation
			System.out.println("APIlogincar");

			
		}
		@DataProvider
		public Object[][] getData()
		{
			//1st combiantion - username password - good credit history= row
			//2nd - username password  - no crdit history
			// 3rd - fraudelent credit history
			Object[][] data= new Object[3][2];
			//1st set 
			data[0][0]="firstsetusername";
			data[0][1]="firstpassword";
			//couloumns in the row are nothing but values for that particualar combination(row)
			
			//2nd set
			data[1][0]= "secondsetusername";
			data[1][1]= "secondpassword";
			
			//3rd set
			data[2][0]="thirdsetusername";
			data[2][1]="thirdpassword";
			return data;
			
} }
