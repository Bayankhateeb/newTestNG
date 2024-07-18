package bayantest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class BaseTest {
    public AppiumDriver driver; 
    public AppiumDriverLocalService service;

    @BeforeClass
    public void startAppiumService() {
        try {
            service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File("AppiumLog.txt"))
                .build();
            service.start();
            Thread.sleep(5000); // Wait for the server to start
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to start Appium service", e);
        }
    }

    @BeforeMethod
    public void initializeDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("BayanMobile");
            options.setApp("/Users/bayanal-khateeb/eclipse-workspace/Appium/src/test/java/sorces/959.apk");
            driver = new AndroidDriver(service.getUrl(), options);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void stopAppiumService() {
        if (service != null) {
            service.stop();
        }
    }
}
