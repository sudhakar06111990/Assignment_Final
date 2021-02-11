package generic;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import utility.Base;
import tests.Test_AbuseReport_NoBroker;

public class BaseTestClass extends Base{
	//ExtentTest test2=null;
	public void tapOnElement(By by, String element) throws Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			MobileElement e1 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(by));
			if (e1.isDisplayed())
			{
				
				e1.click();				
			}
		}
		catch (Exception e)
		{

			
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void inputText(By by, String elementname, String data) throws Exception 
	{
		try 
		{
			wait = new WebDriverWait(driver, 30);
			MobileElement e1 = (MobileElement)wait.until(ExpectedConditions.elementToBeClickable(by));
			if (e1.isDisplayed()) 
			{
				new TouchAction(driver)
				.tap(tapOptions()
						.withElement(ElementOption.element(e1)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(250)))
				.perform();
				e1.clear();
				e1.sendKeys(data);
			}
		} 
		catch (Exception e) 
		{
			//Log
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//ExtentTest test1 = null;
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		//test1.addScreenCaptureFromBase64String(fileWithPath);
    }
	
	public static void takeScreenshotAtEndOfTest(String filename) throws IOException {
		String screenShot = System.getProperty("user.dir")+"\\output\\"+filename+".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(screenShot));
	}
	
	public static void handleAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
    public void SelectDDL(By element, String value)
    {
    	Select dropdown = new Select(driver.findElement(element)); 
    	dropdown.selectByVisibleText(value);
    }
    
    public void verifyPageIsDisplayed(By by, String pageName) throws Exception
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			MobileElement e1 = (MobileElement)wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			if(e1.isDisplayed())
			{
				Test_AbuseReport_NoBroker.test.pass("Page: "+pageName+" displayed correctly (Screenshot attached)");
				//Test_AbuseReport_NoBroker.test.pass("Page: "+pageName+" displayed correctly "+Test_AbuseReport_NoBroker.test.addScreenCaptureFromPath("C:\\Users\\sukumar\\eclipse-workspace\\AppiumDemoTest\\output\\"+pageName+".png"));
				//Test_AbuseReport_NoBroker.test.pass("Page: "+pageName+" displayed correctly "+MediaEntityBuilder.CreateScreenCaptureFromPath(driver.getScreenshotAs()).Build());
				takeScreenshotAtEndOfTest(pageName);
				Test_AbuseReport_NoBroker.test.addScreenCaptureFromPath("C:\\Users\\sukumar\\eclipse-workspace\\AppiumDemoTest\\output\\"+pageName+".png");
			}
			else 
			{
				Test_AbuseReport_NoBroker.test.fail("failed to validate title for the Page: "+pageName+" (Screenshot attached)");
				takeScreenshotAtEndOfTest(pageName);
				Test_AbuseReport_NoBroker.test.addScreenCaptureFromPath("C:\\Users\\sukumar\\eclipse-workspace\\AppiumDemoTest\\output\\"+pageName+".png");
			}

		}
		catch(Exception e)
		{
			
		}
	}
    
	
	public static TapOptions tapOptions() {
		  return new TapOptions();
		}

	public void swipeVertically(By by, double start_xd, double start_yd, double end_xd, double end_yd, int duration) 
	{ 
		Boolean isFoundElement; isFoundElement = driver.findElements(by).size() > 0;
		while(!isFoundElement) 
		{ 
			swipeInVerticalUnits(start_xd, start_yd, end_xd, end_yd, duration); 
			isFoundElement = driver.findElements(by).size() > 0; 
		} 
	}

	@SuppressWarnings("rawtypes")
	public void swipeInVerticalUnits(double start_xd, double start_yd, double end_xd, double end_yd, int duration) 
	{
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int start_x = (int)(size.width*start_xd);
		int start_y = (int)(size.height*start_yd);
		int end_x = (int)(size.width*end_xd);
		int end_y = (int)(size.height*end_yd);
		new TouchAction((PerformsTouchActions)driver)
		.press(PointOption.point(start_x, start_y))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
		.moveTo(PointOption.point(end_x, end_y)).release().perform();
	}
	
	public boolean swipeToText(By by, String attribute, String text, double start_x, double start_y, double end_x, double end_y, int duration) throws InterruptedException
	{
		int a = 0;
		boolean flag = false;
		do
		{
			List<WebElement> lists = driver.findElements(by);
			for(WebElement e : lists)
			{
				if(e.getAttribute(attribute).equalsIgnoreCase(text))
				{
					flag = true;
					break;
				}
			}
			if (!flag)
				swipeInVerticalUnits(start_x, start_y, end_x, end_y, duration);
			a++;
		}
		while(!flag || a==10);
		return flag;
	}
	public String getElementAttribute(By by, String attribute)
	{
		wait = new WebDriverWait(driver, 30);
		MobileElement e1 = (MobileElement)wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return e1.getAttribute(attribute);
	}
}
