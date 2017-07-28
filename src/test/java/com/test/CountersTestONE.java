package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class CountersTestONE {
    protected IOSDriver driver;

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	@BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        desiredCaps.setCapability("automationName","XCUITest");
        desiredCaps.setCapability("platformName", "ios");
        desiredCaps.setCapability("platformVersion", "10.3");
        desiredCaps.setCapability("deviceName", "iPhone 6s");
        
        desiredCaps.setCapability("fullReset", true);
        //this is not the current version of this file. This is not a git repo?
        desiredCaps.setCapability("app", Paths.get("app-debug.apk").toAbsolutePath().toString());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCaps);
    }

  
	@AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

	@Test
	public void testCounters() {
		for (int i = 1; i <= 10; i++) {
			driver.findElementByAccessibilityId("Add").click();
			AssertJUnit.assertTrue(driver.findElement(By.id("android:id/text1")).isDisplayed());
		}
	}
}
