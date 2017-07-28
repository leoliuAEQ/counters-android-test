package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class demotest {
	
	
	public AndroidDriver driver;
	
	AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    String Appium_Node_Path="/Applications/Appium.app/Contents/Resources/node/bin/node";
    String Appium_JS_Path="/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js";
    
@BeforeMethod
	public void setUp() throws MalformedURLException {
	appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
            usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
            withAppiumJS(new File(Appium_JS_Path)));
	appiumService.stop();
appiumService.start();
       // appiumService = AppiumDriverLocalService.buildDefaultService();
		//appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - "+ appiumServiceUrl);
        
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("deviceName", "8d75c47d");
		//capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("deviceName", "Pixel_API_25");
        //this is not the current version of this file. This is not a git repo?
		capabilities.setCapability("app", Paths.get("app-debug.apk").toAbsolutePath().toString());
		
		driver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}



@AfterMethod(alwaysRun = true)
public void tearDown() {
    driver.quit();
    appiumService.stop();
}

@Test
public void testCounters() throws InterruptedException {
	Thread.sleep(3000);
	for (int i = 1; i <= 10; i++) {
		//driver.findElementByAccessibilityId("Add").click();
		//System.out.println("element clicking on add button "+i);
		//Thread.sleep(3000);
		driver.findElement(By.id("Add")).click();
		AssertJUnit.assertTrue(driver.findElement(By.id("android:id/text1")).isDisplayed());
	}
}


//AppiumDriverLocalService appiumService;



}
