import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BroTest {
    AndroidDriver<AndroidElement> driver;
    AppiumDriverLocalService service;

    @Test
    public void broTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "J9AXB760T5085LA");
        capabilities.setCapability(MobileCapabilityType.VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.brouser.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                "com.brouser.android.activity.MyMainActivity");

        driver = new AndroidDriver<>(capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElementById("com.brouser.android:id/display_url").click();
        MobileElement searchBar = driver.findElementById("com.brouser.android:id/urlView");
        searchBar.sendKeys("http://brouser.com");
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.brouser.android:id/mozac_browser_awesomebar_title")));

        driver.findElementById("com.brouser.android:id/mozac_browser_awesomebar_title").click();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
