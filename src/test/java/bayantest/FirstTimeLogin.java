package bayantest;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FirstTimeLogin extends BaseTest {
	 @Test
	    public void SignupValidUnusedEmail() {
	        String enteredEmail = "newuser@wajeez.test";

		 // Click on the email login button
	        clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");


	        // Enter valid unused email in the email input field
	        enterText("//android.widget.EditText[@resource-id=\"email_text_field\"]", enteredEmail);

	        // Click on the continue button
	        clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");
	        // Verify that the password setup screen is displayed
	        String passwordSetupXPath = "//android.widget.TextView[@text=\"أنشئ حساب جديد\"]";
	        String expectedPasswordSetupText = "أنشئ حساب جديد";  // Adjust based on the actual text in your app
	        Assert.assertEquals(getElementText(passwordSetupXPath), expectedPasswordSetupText, "Password setup screen should be displayed");
	     // Verify that the displayed email is the same as the entered email
	        String displayedEmailXPath = String.format("//android.widget.TextView[@text=\"%s\"]", enteredEmail);
	        boolean isEmailDisplayed = isElementDisplayed(displayedEmailXPath);
	       
	    }
//	 

	    // Helper methods
	    private void clickElement(String xpath) {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        driver.findElement(AppiumBy.xpath(xpath)).click();
	    }

	    private void enterText(String xpath, String text) {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        driver.findElement(AppiumBy.xpath(xpath)).sendKeys(text);
	    }

	    private boolean isElementDisplayed(String xpath) {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        try {
	            return driver.findElement(AppiumBy.xpath(xpath)).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    private String getElementText(String xpath) {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return driver.findElement(AppiumBy.xpath(xpath)).getText();
	    }

}
