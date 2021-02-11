package utility;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import helper.PropertyHelper;

public class AndroidUtility extends Base {
	ExtentTest test;
	//public static String appiumServiceUrl;
	
public void setDesiredCapability() throws Exception
{
	//test=extent.createTest("TC001_Verify_abuse_Report_for_Buy_Property");// create a node
	//launchAppiumServer();
	caps=new DesiredCapabilities();
	caps.setCapability("deviceName", PropertyHelper.helperProperty("deviceName"));
	caps.setCapability("udid", PropertyHelper.helperProperty("udid"));
	caps.setCapability("platformName", PropertyHelper.helperProperty("platformName"));
	caps.setCapability("appPackage", PropertyHelper.helperProperty("appPackage"));
	caps.setCapability("automationName", PropertyHelper.helperProperty("automationName"));
	caps.setCapability("appActivity", PropertyHelper.helperProperty("appActivity"));
	//caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
	//caps.setCapability("newCommandTimeout", "960000");
	//caps.setCapability("wdaStartupRetries", "4");

	//caps.setCapability("autoAcceptAlerts", true);
	//caps.setCapability("autoDismissAlerts", true);
	url=new URL(PropertyHelper.helperProperty("CAPABILITY_URL"));
	driver=new AppiumDriver<WebElement>(url,caps);
	//driver=new AppiumDriver<MobileElement>(new URL(appiumServiceUrl),caps);
	//test.pass("User is able to launch No broker application successfully");
}

public void closeDriver() throws MalformedURLException
{
	driver.close();
	driver.quit();
	//server.stop();
	//test.pass("User is able to close driver successfully");
}
public static void launchAppiumServer()
{	
	server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort().withArgument(GeneralServerFlag.SESSION_OVERRIDE));
	server.start();
	//appiumServiceUrl = server.getUrl().toString();
}

}
