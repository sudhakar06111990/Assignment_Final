package utility;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.ExtentReportsDemo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base extends ExtentReportsDemo{
	public static AppiumDriver<WebElement> driver;
	public static AppiumDriverLocalService server;
	public static DesiredCapabilities caps;
	public static URL url;
	public static WebDriverWait wait;
}
