package Mobile.DemoCalculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class InstallAppsInAVD {

    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = null;
        URL url = null;
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.APP, "D:\\Sanjiv_QA\\Eclipse Project\\MobileTesting\\MobileDemo\\Demo\\APKFiles\\selendroid-test-app-0.17.0.apk");

        try {
            url = new URL("http://192.168.1.14:4723/wd/hub/");
            driver = new AndroidDriver<AndroidElement>(url, cap);
            System.out.println("Android driver started");

            // Your test code here

        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver quit");
            }
        }
    }
}
