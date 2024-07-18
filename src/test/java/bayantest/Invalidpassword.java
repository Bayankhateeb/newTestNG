package bayantest;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Invalidpassword extends BaseTest {
	
	
	@Test
	  public void validSignin() {
	        // Click on the email login button
	        clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");

	        // Enter email in the email input field
	        enterText("//android.widget.EditText[@resource-id=\"email_text_field\"]", "kareem@wajeez.test");

	        // Click on the continue button
	        clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");

	        // Enter password in the password input field
	        enterText("//android.widget.EditText[@resource-id=\"password_text_field\"]", "12345678");

	        // Click on the login button
	        clickElement("//android.view.View[@resource-id=\"login_button\"]/android.widget.Button");

	        // Handle permission dialog if it appears
	        handlePermissionDialog();

	        // Assert that the main screen ('الرئيسية') is displayed
	        Assert.assertTrue(isElementDisplayed("(//android.widget.TextView[@text=\"الرئيسية\"])[1]"), "الرئيسية");
	   }
	@Test
	public void SiginInvalidEmail() {
	    // Click on the email login button
	    clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");
        enterText("//android.widget.EditText[@resource-id=\"email_text_field\"]", "kareem@wajeeztest");


	    // Click on the continue button
	    clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");

	    // Leave the email field empty and click on the login button

	    // Verify that the error message is displayed for the empty password field
	    String emptyPasswordErrorXPath = "//android.widget.TextView[@text=\"يرجى إدخال صيغة بريد إلكتروني صحيحة\"]";
	    String expectedEmptyPasswordError = "يرجى إدخال صيغة بريد إلكتروني صحيحة";
	    Assert.assertEquals(getElementText(emptyPasswordErrorXPath), expectedEmptyPasswordError, "Error message for empty password should match expected text");
	}
@Test
	public void SiginEmptyEmail() {
	    // Click on the email login button
	    clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");

	    // Click on the continue button
	    clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");

	    // Leave the email field empty and click on the login button

	    // Verify that the error message is displayed for the empty password field
	    String emptyPasswordErrorXPath = "//android.widget.TextView[@text=\"هذا الحقل مطلوب\"]";
	    String expectedEmptyPasswordError = "هذا الحقل مطلوب";
	    Assert.assertEquals(getElementText(emptyPasswordErrorXPath), expectedEmptyPasswordError, "Error message for empty password should match expected text");
	}



    @Test
	  public void cancelSigin() {
	        // Click on the email login button
	        clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");
		    clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");

	        // Enter email in the email input field
	        enterText("//android.widget.EditText[@resource-id=\"email_text_field\"]", "kareem@wajeez.test");
		    clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");

	        // Enter password in the password input field
	        enterText("//android.widget.EditText[@resource-id=\"password_text_field\"]", "12345678");

	        // Click on the back  button
	        clickElement("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
	        Assert.assertTrue(isElementDisplayed("(//android.widget.TextView[@text=\"تسجيل الدخول باستخدام البريد الإلكتروني\"]"), "تسجيل الدخول باستخدام البريد الإلكتروني");

	        
	        
    }

    public void SigninInvalidPassword() {
        // Click on the email login button
        clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");

        // Enter email in the email input field
        enterText("//android.widget.EditText[@resource-id=\"email_text_field\"]", "kareem@wajeez.test");

        // Click on the continue button
        clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");

        // Enter password in the password input field with invalid password
        enterText("//android.widget.EditText[@resource-id=\"password_text_field\"]", "wrongpassword");

        // Click on the login button
        clickElement("//android.view.View[@resource-id=\"login_button\"]/android.widget.Button");

        // Assert that the main screen ('الرئيسية') is NOT displayed
   //    Assert.assertFalse(isElementDisplayed("(//android.widget.TextView[@text=\"الرئيسية\"])[1]"), "الرئيسية");

        // Check for the presence of the error message container
       // String errorMessageContainerXPath = "//android.view.ViewGroup[@resource-id=\"com.faylasof.android.waamda:id/container\"]";
     //   Assert.assertTrue(isElementDisplayed(errorMessageContainerXPath), "Error message container should be displayed");

        // Verify the actual error message text
        String errorMessageXPath = "//android.widget.TextView[@resource-id=\"com.faylasof.android.waamda:id/tvMessage\"]";
        String expectedErrorMessage = "عذراً، البريد الإلكتروني أو كلمة المرور غير صحيحة";
        Assert.assertEquals(getElementText(errorMessageXPath), expectedErrorMessage, "Error message should match expected text");
    }


@Test
public void SigninEmptyPassword() {
    // Click on the email login button
    clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");

    // Enter email in the email input field
    enterText("//android.widget.EditText[@resource-id=\"email_text_field\"]", "kareem@wajeez.test");

    // Click on the continue button
    clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");

    // Leave the password field empty and click on the login button
    clickElement("//android.view.View[@resource-id=\"login_button\"]/android.widget.Button");

    // Verify that the error message is displayed for the empty password field
    String emptyPasswordErrorXPath = "//android.widget.TextView[@text=\"هذا الحقل مطلوب\"]";
    String expectedEmptyPasswordError = "هذا الحقل مطلوب";
    Assert.assertEquals(getElementText(emptyPasswordErrorXPath), expectedEmptyPasswordError, "Error message for empty password should match expected text");
}


    // Helper method to find element by XPath and click
    private void clickElement(String xpath) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(AppiumBy.xpath(xpath)).click();
    }

    // Helper method to find element by XPath and enter text
    private void enterText(String xpath, String text) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(AppiumBy.xpath(xpath)).sendKeys(text);
    }

    // Helper method to handle permission dialog if it appears
    private void handlePermissionDialog() {
        try {
            Thread.sleep(7000); // Adjust as per your application's behavior
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            // Assuming this is the permission dialog's element, modify if needed
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
        } catch (Exception e) {
            // Handle exception if permission dialog does not appear
            e.printStackTrace();
        }
    }

    // Helper method to check if an element is displayed
    private boolean isElementDisplayed(String xpath) {
        try {
            Thread.sleep(5000); // Adjust as per your application's behavior
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return driver.findElement(AppiumBy.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Helper method to get text from an element
    private String getElementText(String xpath) {
        try {
            Thread.sleep(1000); // Adjust as per your application's behavior
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(AppiumBy.xpath(xpath)).getText();
    }
}
