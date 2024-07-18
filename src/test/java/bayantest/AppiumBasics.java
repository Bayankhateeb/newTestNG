package bayantest;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest {

    @Test
    public void Signin() {
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
//    @Test
//    public void SigninInvalidPassword() {
//        // Click on the email login button
//        clickElement("//android.view.View[@resource-id=\"email_login_button\"]/android.widget.Button");
//
//        // Enter email in the email input field
//        enterText("//android.widget.EditText[@resource-id=\"email_text_field\"]", "kareem@wajeez.test");
//
//        // Click on the continue button
//        clickElement("//android.view.View[@resource-id=\"continue_button\"]/android.widget.Button");
//
//        // Enter password in the password input field with invalid password
//        enterText("//android.widget.EditText[@resource-id=\"password_text_field\"]", "wrongpassword");
//
//        // Click on the login button
//        clickElement("//android.view.View[@resource-id=\"login_button\"]/android.widget.Button");
//
//        // Assert that the main screen ('الرئيسية') is NOT displayed
//     //   Assert.assertFalse(isElementDisplayed("(//android.widget.TextView[@text=\"الرئيسية\"])[1]"), "الرئيسية should not be displayed");
//
//        // Optionally, check for an error message indicating login failure
//        Assert.assertTrue(isElementDisplayed("//android.view.ViewGroup[@resource-id=\"com.faylasof.android.waamda:id/container\"]"), "عذراً، البريد الإلكتروني أو كلمة المرور غير صحيحة");
//    }
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
            Thread.sleep(8000); // Adjust as per your application's behavior
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
        return driver.findElement(AppiumBy.xpath(xpath)).isDisplayed();
    }
}
