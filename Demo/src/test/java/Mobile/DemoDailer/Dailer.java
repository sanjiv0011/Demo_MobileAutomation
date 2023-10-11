package Mobile.DemoDailer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class Dailer {

		//TO LOGS THE ACTIVITY
		final static Logger logger = LogManager.getLogger(Dailer.class);
		
		//FOR THE ASSERTIONS
		public static SoftAssert softAssert = new SoftAssert();
		
		
		//DIALER ELEMENT
		public static WebElement dialerIcon;
		
		public static WebElement digit9;
		public static WebElement digit8;
		public static WebElement digit7;
		public static WebElement digit6;
		public static WebElement digit5;
		public static WebElement digit4;
		public static WebElement digit3;
		public static WebElement digit2;
		public static WebElement digit1;
		public static WebElement digit0;
		
		public static WebElement starSign;
		public static WebElement hashSign;
		public static WebElement deleteButton;
		public static WebElement dailDigits;
		public static WebElement callButton;
		
		public static WebElement recentTab;
		public static WebElement contactTab;
		public static WebElement voiceMailTab;
		public static WebElement favoriteTab;
		
		
		
		 
		
		//MAIN METHODS  
		public static void main(String[] args) throws MalformedURLException, InterruptedException
		{
			logger.info("Main methods started");
			AndroidDriver<AndroidElement> driver = null;
			URL url = null;
			
			
	        DesiredCapabilities cap = new DesiredCapabilities();
	        
	        logger.info("Start to set capabilities");
	        //CAPABILITY SETTING
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
	        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	        
	        //FOR THE NATIVE APPS PROVIDES THIS DETAILS
	        cap.setCapability("appPackage", "com.google.android.dialer");
	        cap.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
	        
	        
	        
	        try {
	            url = new URL("http://192.168.1.14:4723/wd/hub/");
	            logger.info("Server url matched");
	            driver = new AndroidDriver<AndroidElement>(url, cap);
	            logger.info("Started the Android Driver");
		        Thread.sleep(5000);
		        
		        
			    //DAIL A NUMBER
		        String numberWantToDial = "1234568790";
		        callDailNumber(driver,numberWantToDial);
		        
		        //TO CLICK ON TAB AND BUTTONS
		        clickActionOnTabAndButton(driver);
			    
		        
		    } catch (MalformedURLException e) {
		            System.out.println("\n MalformedURLException From: " + e.getMessage());
		            e.printStackTrace();
		        } catch (Exception ex) {
		            System.out.println("\n Exception From: " + ex.getMessage());
		            ex.printStackTrace();
		        } finally {
		            if (driver != null) {
		                driver.quit();
		                System.out.println("Driver quit");
		            }else {
		            	System.out.println("Driver is null");
		            }
		        }
        
	    }
		
		//DAIL AND NUMBER ON THE NUMBER
		public static void callDailNumber(AndroidDriver<AndroidElement> driver, String number1) throws InterruptedException {
			logger.info("Methods called: callDailNumber");
			
			//TO THE DAIL BUTTON, CLICK ON THE DIALER ICON
			dialerIcon = driver.findElement(By.id("com.google.android.dialer:id/fab"));
			dialerIcon.click();
			logger.info("Clicked on the dialer button");
			Thread.sleep(3000);
			
	        int dailDigit[] = FindSingleDigitFromString.findDigit(number1);
	        for(int x : dailDigit) {
	        	clickOnDigit(driver,x);
	        }
	        
	        //TO CHECK THE DIAL DIGITES
	        dailDigits = driver.findElement(By.id("com.google.android.dialer:id/digits"));
	        Thread.sleep(500);
	        String dialNumber = dailDigits.getText();
	        String dialText = dialNumber.replaceAll("-","").replaceAll(" ","").trim();;
	        
	        logger.info("Dial text is: "+dialText);
	        Thread.sleep(500);
	        //TO HIT THE CALL BUTTON
	        callButton = driver.findElement(By.id("com.google.android.dialer:id/dialpad_floating_action_button"));	
	        Thread.sleep(500);
	        callButton.click();
	        logger.info("Clicked on the call button");
	        logger.info("Dail text: "+dialText+" and input number: "+number1);
	        softAssert.assertEquals(dialText,number1,"To matche the dial number and input number");
	        Thread.sleep(3000);
	        softAssert.assertAll();
	      
		}
		
		//CLICK ACTIONS ON THE TAB ELEMENTS
		public static void clickActionOnTabAndButton(AndroidDriver<AndroidElement> driver) throws InterruptedException {
			//TAB ELEMENTS
	        recentTab = driver.findElement(By.id("com.google.android.dialer:id/call_log_tab"));
	        contactTab = driver.findElement(By.id("com.google.android.dialer:id/contacts_tab"));
	        voiceMailTab = driver.findElement(By.id("com.google.android.dialer:id/voicemail_tab"));
	        favoriteTab = driver.findElement(By.id("com.google.android.dialer:id/speed_dial_tab"));
	        
	        recentTab.click();
	        logger.info("Clicked on the recentTab ");
	        Thread.sleep(1000);
	        contactTab.click();
	        logger.info("Clicked on the contactTab ");
	        Thread.sleep(1000);
	        voiceMailTab.click();
	        logger.info("Clicked on the voiceMailTab ");
	        Thread.sleep(1000);
	        favoriteTab.click();
	        logger.info("Clicked on the favoriteTab ");
	        Thread.sleep(1000);
	        
	        dialerIcon = driver.findElement(By.id("com.google.android.dialer:id/fab"));
			dialerIcon.click();
			logger.info("Clicked on the dialer button");
			Thread.sleep(3000);
	        
	        starSign = driver.findElement(By.id("com.google.android.dialer:id/star"));	
	        hashSign = driver.findElement(By.id("com.google.android.dialer:id/pound"));	
	        deleteButton = driver.findElement(By.id("com.google.android.dialer:id/deleteButton"));	
	        
	        starSign.click();
	        logger.info("Clicked on the starSign ");
	        Thread.sleep(500);
	        
	        hashSign.click();
	        logger.info("Clicked on the hashSign ");
	        Thread.sleep(500);
	        
	        digit0 = driver.findElement(By.id("com.google.android.dialer:id/zero"));
			digit0.click();
			logger.info("Clicked on digit 0");
			Thread.sleep(500);
			
	        deleteButton.click();
	        logger.info("Clicked on the deleteButton ");
	        Thread.sleep(500);
	        
	        driver.navigate().back();
	        logger.info("Clicked on the device back button");
	        Thread.sleep(1000);
//	        driver.navigate().back();
//	        logger.info("Clicked on the device back button");
//	        Thread.sleep(1000);
	        
	        
		}
	
		//METHODS TO CLICK ON THE ANY NUMBER
		public static void clickOnDigit(AndroidDriver<AndroidElement> driver, int digit) throws InterruptedException 
		{
			int number = digit;
			
	        //TO SELECT THE UNIQUE DIGIT
	        switch(number) 
	        {
				case 0:
				{ 
					digit0 = driver.findElement(By.id("com.google.android.dialer:id/zero"));
					digit0.click();
					logger.info("Clicked on digit 0");
					Thread.sleep(500);
					break;
					
				}
				case 1:
				{
					digit1 = driver.findElement(By.id("com.google.android.dialer:id/one"));
					digit1.click();
					logger.info("Clicked on digit 1");
					Thread.sleep(500);
					break;
				}
				case 2:
				{
					digit2 = driver.findElement(By.id("com.google.android.dialer:id/two"));
					digit2.click();
					logger.info("Clicked on digit 2");
					Thread.sleep(500);
					break;
				}
				case 3:
				{ 
					digit3 = driver.findElement(By.id("com.google.android.dialer:id/three"));
					digit3.click();
					logger.info("Clicked on digit 3");
					Thread.sleep(500);
					break;
				}
				case 4:
				{
					digit4 = driver.findElement(By.id("com.google.android.dialer:id/four"));
					digit4.click();
					logger.info("Clicked on digit 4");
					Thread.sleep(500);
					break;
				}
				case 5:
				{
					digit5 = driver.findElement(By.id("com.google.android.dialer:id/five"));
					digit5.click();
					logger.info("Clicked on digit 5");
					Thread.sleep(500);
					break;
				}
				case 6:
				{ 
					digit6 = driver.findElement(By.id("com.google.android.dialer:id/six"));
					digit6.click();
					logger.info("Clicked on digit 6");
					Thread.sleep(500);
					break;
				}
				case 7:
				{
					digit7 = driver.findElement(By.id("com.google.android.dialer:id/seven"));
					digit7.click();
					logger.info("Clicked on digit 7");
					Thread.sleep(500);
					break;
				}
				case 8:
				{
					digit8 = driver.findElement(By.id("com.google.android.dialer:id/eight"));
					digit8.click();
					logger.info("Clicked on digit 8");
					Thread.sleep(500);
					break;
				}
				case 9:
				{
					digit9 = driver.findElement(By.id("com.google.android.dialer:id/nine"));
					digit9.click();
					logger.info("Clicked on digit 9");
					Thread.sleep(500);
					break;
				}
	        }
		}
		
}
