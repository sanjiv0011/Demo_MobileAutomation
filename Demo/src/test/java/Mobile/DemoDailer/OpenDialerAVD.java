package Mobile.DemoDailer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

public class OpenDialerAVD {

	//TO LOGS THE ACTIVITY
	final static Logger logger = LogManager.getLogger(OpenDialerAVD.class);
	
	//MAIN METHODS
    public static void main(String[] args) {
    	logger.info("Main method started");
    	
    	//TO SET ANDROID DRIVER BY PASSING ADNROID ELEMENT AS AN AGRUMENT
        AndroidDriver<AndroidElement> driver = null;
        URL url = null;
        
        //TO SET THE DESIRED CAPABILITIES
        DesiredCapabilities cap = new DesiredCapabilities();
        
        logger.info("Start setting desired capabitlies");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "appium");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        
        //FOR THE NATIVE APPS PROVIDES THIS DETAILS
        cap.setCapability("appPackage", "com.google.android.dialer");
        cap.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
        
        
        try {
            url = new URL("http://192.168.1.14:4723/wd/hub/");
            logger.info("Matches the server url");
            
            driver = new AndroidDriver<AndroidElement>(url, cap);
            logger.info("Started dndroid driver");
            Thread.sleep(4000);

        } catch (MalformedURLException e) {
        	 logger.info("MalformedURLException From: " + e.getMessage());
        } catch (Exception ex) {
        	 logger.info("Exception From: " + ex.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                logger.info("Driver quit");
            }
        }
    }
}
