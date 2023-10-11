package Mobile.DemoCalculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class InstallAppsInARD {

		public static void main(String[] args) throws MalformedURLException {
		 AndroidDriver driver = null;
		 URL url = null;
        DesiredCapabilities cap = new DesiredCapabilities();
        

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2 N2G47H");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "f937f2a07d83");
        cap.setCapability(MobileCapabilityType.APP, "D:\\Sanjiv_QA\\Eclipse Project\\MobileTesting\\MobileDemo\\Demo\\APKFiles\\selendroid-test-app-0.17.0.apk");
       
        try {
            url = new URL("http://192.168.1.14:4723/wd/hub/");
            driver = new AndroidDriver(url, cap);
            System.out.println("Android driver started");


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
