import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import static org.testng.Assert.assertTrue;

/**
 * Created by user on 2017-06-28.
 */
public class CountersTest {
    protected AppiumDriver driver;

 
	@BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        desiredCaps.setCapability("platformName", "android");
        desiredCaps.setCapability("deviceName", "Pixel_API_25");
        //this is not the current version of this file. This is not a git repo?
        desiredCaps.setCapability("app", Paths.get("app-debug.apk").toAbsolutePath().toString());
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCaps);
    }

  
	@AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCounters() {
        driver.findElementByAccessibilityId("Add").click();
        AssertJUnit.assertTrue(driver.findElement(By.id("android:id/text1")).isDisplayed());
    }
}
