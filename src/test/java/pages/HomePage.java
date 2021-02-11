package pages;
import java.io.IOException;

import org.openqa.selenium.By;
import tests.Test_AbuseReport_NoBroker;
import utility.Base;


public class HomePage extends Base{
	//ExtentTest test1;
	
	public static By btnContinue = By.id("com.nobroker.app:id/yesPhoneState");
	public static By btnAllowPermission = By.id("com.android.packageinstaller:id/permission_allow_button");
	public static By btnBuy = By.id("com.nobroker.app:id/buyLayout");
	public static By edtSearchLocations = By.id("com.nobroker.app:id/localityAutoCompleteTxt");
	public static By lstFirstEntry = By.id("com.nobroker.app:id/logo");
	public static By chkIncludeNearByProperties = By.id("com.nobroker.app:id/nearByRadio");
	public static By ttlHome = By.id("com.nobroker.app:id/homeTitle");
	public static By btnSearch = By.id("com.nobroker.app:id/locationImageHome");

	public void ClickContinue() throws IOException
	{
		driver.findElement(btnContinue).click();
		Test_AbuseReport_NoBroker.test.pass("User clicked on continue button to reach home page");
		//BaseTestClass.takeScreenshotAtEndOfTest("Permission_Screenshot_v1");	
	}
	
	public void ClickAllowPermission() throws IOException
	{
		driver.findElement(btnAllowPermission).click();
		Test_AbuseReport_NoBroker.test.pass("User clicked on allow permission button successfully");
		//BaseTestClass.takeScreenshotAtEndOfTest("Home_Page");
	}
	
	public void ClickBuyButton() throws Exception
	{
		driver.findElement(btnBuy).click();
		Test_AbuseReport_NoBroker.test.pass("Clicking on Buy button over home page has been done successfully");	
	}
	
	public void ClickSearchHome() throws Exception
	{
		driver.findElement(btnSearch).click();
		Test_AbuseReport_NoBroker.test.pass("Clicked on Search button over home page done successfully");
	}
		
	
}
