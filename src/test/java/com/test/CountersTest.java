package com.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static org.testng.Assert.assertTrue;

/**
 * Created by user on 2017-06-28.
 */
public class CountersTest {
    protected AndroidDriver driver;

 	@BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        desiredCaps.setCapability("platformName", "android");
        desiredCaps.setCapability("deviceName", "android Emulator");
        //this is not the current version of this file. This is not a git repo?
        desiredCaps.setCapability("app", Paths.get("app-debug.apk").toAbsolutePath().toString());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCaps);
        System.out.println("Appium Driver started succussfully");
    }

	@AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

	@Test
	public void testCounters() throws InterruptedException {
		
		for (int i = 1; i <= 10; i++) {
			//driver.findElementByAccessibilityId("Add").click();
			System.out.println("element clicking on add button "+i);
			//driver.findElement(By.xpath("//android.widget.Button")).click();
						driver.findElement(By.id("Add")).click();
						//driver.findElement(By.name("Add")).click();


						//driver.findElement(By.xpath("//*[@content-desc='Add']")).click();
			//AssertJUnit.assertTrue(driver.findElement(By.id("android:id/text1")).isDisplayed());
		}
	}
}
