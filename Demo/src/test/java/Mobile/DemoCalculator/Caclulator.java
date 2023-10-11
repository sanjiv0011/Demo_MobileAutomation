package Mobile.DemoCalculator;

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

public class Caclulator {

		//TO LOGS THE ACTIVITY
		final static Logger logger = LogManager.getLogger(Caclulator.class);
		
		//FOR THE ASSERTIONS
		public static SoftAssert softAssert = new SoftAssert();
		
		//DIGITS BUTTONS
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
		 
		//ACTIONS BUTTONS
		public static WebElement allClear;
		//public static WebElement result;
		public static WebElement equal;
		public static WebElement divide;
		public static WebElement minus;
		public static WebElement plus; 
		public static WebElement dot;
		public static WebElement multiply;
		  
		  
		
		//MAIN METHODS  
		public static void main(String[] args) throws MalformedURLException, InterruptedException
		{
			
			AndroidDriver<AndroidElement> driver = null;
			URL url = null;
			
			
	        DesiredCapabilities cap = new DesiredCapabilities();
	        
	        logger.info("Start to set capabilities");
	        //CAPABILITY SETTING
	        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2 N2G47H");
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "f937f2a07d83");
	        
	        //FOR THE NATIVE APPS PROVIDES THIS DETAILS
	        cap.setCapability("appPackage", "com.miui.calculator");
	        cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
	        
	        logger.info("Start finding the url");
	        
	        try {
	            url = new URL("http://192.168.1.14:4723/wd/hub/");
	            driver = new AndroidDriver<AndroidElement>(url, cap);
		        Thread.sleep(1000);
		        
		        
		        //DIGITS ADDRESSES
		        digit9 = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
		        digit8 = driver.findElement(By.id("com.miui.calculator:id/btn_8_s"));
		        digit7 = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
		        digit6 = driver.findElement(By.id("com.miui.calculator:id/btn_6_s"));
		        digit5 = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
		        digit4 = driver.findElement(By.id("com.miui.calculator:id/btn_4_s"));
		        digit3 = driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));
		        digit2 = driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
		        digit1 = driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
		        digit0 = driver.findElement(By.id("com.miui.calculator:id/btn_0_s"));
		        
		        
		        
		        //ACTION BUTTONS
		        allClear = driver.findElement(By.id("com.miui.calculator:id/btn_c_s"));
			    //result = driver.findElement(By.className("android.widget.TextView"));
			    equal = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
			    divide = driver.findElement(By.id("com.miui.calculator:id/btn_div_s"));
			    minus = driver.findElement(By.id("com.miui.calculator:id/btn_minus_s"));
			    plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
			    dot = driver.findElement(By.id("com.miui.calculator:id/btn_dot_s"));
			    multiply = driver.findElement(By.id("com.miui.calculator:id/btn_mul_s"));
			    
			    //CALCULATIONS
			    multiplication(5,3);
			    division(9,3);
			    substruction(8,5);
			    addition(8,2);
		        
		        } catch (MalformedURLException e) {
		            System.out.println("\n MalformedURLException: " + e.getMessage());
		            e.printStackTrace();
		        } catch (Exception ex) {
		            System.out.println("\n Exception: " + ex.getMessage());
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
		
		//MULTIPLICATION
		public static void multiplication(int number1, int number2) throws InterruptedException {
	        clickOnDigit(number1);
	        multiply.click();
	        logger.info("Clicked on the multiply button");
	        clickOnDigit(number2);
	        equal.click();
	        logger.info("Clicked on the equal button");
	        Thread.sleep(500);
//	        String resultFromCalc = result.getText().trim();
//	        logger.info("resultFromCalc: "+resultFromCalc);
//	        
//	        int ans = 0;
//	        try {
//	        	ans = Integer.parseInt(resultFromCalc);
//	        }catch(NumberFormatException  e) {
//	        	logger.info("Exception from: multiplication"+e.getMessage());
//	        }
//	        
//	        softAssert.assertEquals(ans, number1*number2,"Check mulitplication");
	     // softAssert.assertAll();
	        
	        
	        allClear.click();
	        logger.info("Result cleared");
	        Thread.sleep(1000);
	      
		}
		
		//DIVISION
		public static void division(int number1, int number2) throws InterruptedException {
		    
			clickOnDigit(number1);
			divide.click();
	        logger.info("Clicked on the divide button");
	        clickOnDigit(number2);
	        equal.click();
	        logger.info("Clicked on the equal button");
	        Thread.sleep(500);
	        
//	        String resultFromCalc = result.getText().trim();
//	        logger.info("resultFromCalc: "+resultFromCalc);
//	        
//	        int ans = 0;
//	        try {
//	        	ans = Integer.parseInt(resultFromCalc);
//	        }catch(NumberFormatException  e) {
//	        	logger.info("Exception from: division"+e.getMessage());
//	        }
//	        
//	        softAssert.assertEquals(ans, number1*number2,"Check division");
	        // softAssert.assertAll();
	        
	        allClear.click();
	        logger.info("Result cleared");
	        Thread.sleep(1000);
	      
		   }
			
		//SUBSTUCTIONS
		public static void substruction(int number1, int number2) throws InterruptedException {
		    
			clickOnDigit(number1);
	        minus.click();
	        logger.info("Clicked on the minus button");
	        clickOnDigit(number2);
	        equal.click();
	        logger.info("Clicked on the equal button");
	        Thread.sleep(500);
	        
//	        String resultFromCalc = result.getText().trim();
//	        logger.info("resultFromCalc: "+resultFromCalc);
//	        
//	        int ans = 0;
//	        try {
//	        	ans = Integer.parseInt(resultFromCalc);
//	        }catch(NumberFormatException  e) {
//	        	logger.info("Exception from: substruction"+e.getMessage());
//	        }
//	        
//	        softAssert.assertEquals(ans, number1*number2,"Check substruction");
	        // softAssert.assertAll();
	        
	        allClear.click();
	        logger.info("Result cleared");
	        Thread.sleep(1000);
	      
		   
		   }
		
		
		//ADDITIONS
		public static void addition(int number1, int number2) throws InterruptedException {
		    
			clickOnDigit(number1);
	        plus.click();
	        logger.info("Clicked on the plus button");
	        clickOnDigit(number2);
	        equal.click();
	        logger.info("Clicked on the equal button");
	        Thread.sleep(500);
	        
//	        String resultFromCalc = result.getText().trim();
//	        logger.info("resultFromCalc: "+resultFromCalc);
//	        
//	        int ans = 0;
//	        try {
//	        	ans = Integer.parseInt(resultFromCalc);
//	        }catch(NumberFormatException  e) {
//	        	logger.info("Exception from: addition"+e.getMessage());
//	        }
//	        
//	        softAssert.assertEquals(ans, number1*number2,"Check addition");
	        // softAssert.assertAll();
	        allClear.click();
	        logger.info("Result cleared");
	        Thread.sleep(1000);
	      
		    
		}


		public static void clickOnDigit(int digit) throws InterruptedException 
		{
			int number = digit;
			
	        //TO SELECT THE UNIQUE DIGIT
	        switch(number) 
	        {
				case 0:
				{ 
					digit0.click();
					logger.info("Clicked on digit 0");
					Thread.sleep(500);
					break;
					
				}
				case 1:
				{
					digit1.click();
					logger.info("Clicked on digit 1");
					Thread.sleep(500);
					break;
				}
				case 2:
				{
					digit2.click();
					logger.info("Clicked on digit 2");
					Thread.sleep(500);
					break;
				}
				case 3:
				{ 
					digit3.click();
					logger.info("Clicked on digit 3");
					Thread.sleep(500);
					break;
				}
				case 4:
				{
					digit4.click();
					logger.info("Clicked on digit 4");
					Thread.sleep(500);
					break;
				}
				case 5:
				{
					digit5.click();
					logger.info("Clicked on digit 5");
					Thread.sleep(500);
					break;
				}
				case 6:
				{ 
					digit6.click();
					logger.info("Clicked on digit 6");
					Thread.sleep(500);
					break;
				}
				case 7:
				{
					digit7.click();
					logger.info("Clicked on digit 7");
					Thread.sleep(500);
					break;
				}
				case 8:
				{
					digit8.click();
					logger.info("Clicked on digit 8");
					Thread.sleep(500);
					break;
				}
				case 9:
				{
					digit9.click();
					logger.info("Clicked on digit 9");
					Thread.sleep(500);
					break;
				}
	        }
		}
}
