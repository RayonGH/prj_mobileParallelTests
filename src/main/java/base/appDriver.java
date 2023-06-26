package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class appDriver {
    public static ThreadLocal<AndroidDriver<AndroidElement>> driver = new ThreadLocal<>();

    public static AndroidDriver<AndroidElement> getDriver()
    {
        return driver.get();
    }

    public static void setDriver (AndroidDriver<AndroidElement> androidDriver)
    {
        driver.set(androidDriver);
    }

    public static void initializeDriver(String udid, String platformVersion, String portNumber) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        desiredCapabilities.setCapability("appPackage", "io.selendroid.testapp");
        desiredCapabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");

        URL url = new URL("http://127.0.0.1:"+portNumber+"/wd/hub");

        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(url, desiredCapabilities);
        setDriver(androidDriver);
    }
    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
