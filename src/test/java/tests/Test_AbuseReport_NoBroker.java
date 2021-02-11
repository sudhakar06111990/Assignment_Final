package tests;
import java.awt.Component;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;

import generic.BaseTestClass;
import helper.PropertyHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.HomePage;
import pages.LoginPage;
import pages.ReportClass;
import pages.SearchResultPage;
import pages.SuggestEdit;
import utility.AndroidUtility;
import utility.Base;

public class Test_AbuseReport_NoBroker extends BaseTestClass{
	
	//Launching No broker Application
	//ExtentTest report_obj=extent.createTest("Test Case 1", "Abuse Report for No broker");
	AndroidUtility utlity_obj=new AndroidUtility();
	HomePage obj_home=new HomePage();

	BaseTestClass basetc_obj=new BaseTestClass();
	public static ExtentTest test;
	
	@BeforeClass
	public void intializeDriver() throws Exception
	{
		test=extent.createTest("TC001_Verify_abuse_Report_for_Buy_Property").assignDevice("deviceName: Pixel 4 API 28").assignAuthor("Author: Sudhakar").assignCategory("platformName: Android").assignCategory("appPackage: com.nobroker.app").assignCategory("Capability URL: http://127.0.0.1:4723/wd/hub");// create a node	
		utlity_obj.setDesiredCapability();
		test.pass("User is able to launch No broker application successfully");
	}
	
	
	

	@Test
	public void test_abuse() throws Exception
	{	
		//Clicking on continue button to reach home page
		obj_home.ClickContinue();
		
		//Click on Allow button In The Permission Window
		Thread.sleep(1000);
		obj_home.ClickAllowPermission();
		Thread.sleep(1000);
		obj_home.ClickAllowPermission();
		Thread.sleep(1000);
		obj_home.ClickAllowPermission();
		
		//Clicking On The Buy Tab
		Thread.sleep(1000);
		obj_home.ClickBuyButton();	
		
		//Validated home page title
		basetc_obj.verifyPageIsDisplayed(HomePage.ttlHome, "World's Largest NoBrokerage Property Site");
		
		//Clicking On The Search Related Box
		obj_home.ClickSearchHome();
		
		//Verify Related Search Section Is Displayed
		basetc_obj.verifyPageIsDisplayed(SearchResultPage.lstBoxPlaces, "Search Related Section");

		//Selected city from the drop down as 'Bangalore'
		basetc_obj.SelectDDL(SearchResultPage.lstBoxPlaces, PropertyHelper.helperProperty("city"));
				
		//Entered Location Search text Field 
		basetc_obj.inputText(SearchResultPage.edtSearchLocations, "Search Location", PropertyHelper.helperProperty("location1"));

		//Selected above location from from the drop-down from the autosuggestion
		basetc_obj.tapOnElement(HomePage.btnSearch, "Search Button");
	
		//Entered Location Search text Field 
		basetc_obj.inputText(SearchResultPage.edtSearchLocations, "Search Location", PropertyHelper.helperProperty("location2"));

		//Selected above location from from the drop-down from the autosuggestion
		basetc_obj.tapOnElement(HomePage.btnSearch, "Search Button");
	
		//User clicked on Include Nearby Properties CheckBox element
		basetc_obj.tapOnElement(SearchResultPage.chkIncludeNearByProperties, "Include Nearby Propertis Check Box");

		//User clicked on Search element
		basetc_obj.tapOnElement(HomePage.btnSearch, "Search Button");
		
		//Validated result Page
		basetc_obj.verifyPageIsDisplayed(SearchResultPage.pgSearch, "Search Result");
		
		//Scroll down till fourth tile and Clicked on 4th Property Image element
		for (int i = 0; i <=1;i++)
			basetc_obj.swipeInVerticalUnits(0.5, 0.9, 0.5, 0.2, 2);
		basetc_obj.tapOnElement(SearchResultPage.imgThumbnail, "Property Image");
		
		
		//Validated Result Page
		basetc_obj.verifyPageIsDisplayed(SearchResultPage.btnOwnerContact, "Specific Propery Result");

		//Validated wrong info element
		basetc_obj.swipeToText(SearchResultPage.txtWrongInfo, "text", "Wrong Info", 0.5, 0.9, 0.5, 0.2, 2);

		//Clicked on Wrong Info element
		basetc_obj.tapOnElement(SearchResultPage.txtWrongInfo, "Wrong Info");

		//Validated nobroker page
		basetc_obj.verifyPageIsDisplayed(LoginPage.txtPhoneNumber, "No Broker Login");

		//Entered Phone Number Text
		basetc_obj.inputText(LoginPage.txtPhoneNumber, "Phone Number", PropertyHelper.helperProperty("username"));

		
		//Clicked on Password Radio button element
		basetc_obj.tapOnElement(LoginPage.radioPassword, "Password Radio Button");

		
		//Entered Password 
		basetc_obj.inputText(LoginPage.editPassword, "Password", PropertyHelper.helperProperty("password"));
		basetc_obj.swipeInVerticalUnits(0.125, 0.5, 0.125, 0.145, 2);

		//Clicked on continue button
		basetc_obj.tapOnElement(LoginPage.btnContinue, "Continue Button"); 

		//Validated Report Page
		basetc_obj.verifyPageIsDisplayed(ReportClass.btnReport, "Report");

		//Clicked on all checkboxes
		basetc_obj.tapOnElement(ReportClass.chkLocation, "Location Check Box");
		basetc_obj.tapOnElement(ReportClass.chkFakePhotos, "Fake Photos Check Box");
		basetc_obj.tapOnElement(ReportClass.chkBHKType, "BHK Type Check Box");
		basetc_obj.tapOnElement(ReportClass.chkAvailabilityDate, "Availability Date Check Box");
		basetc_obj.tapOnElement(ReportClass.chkPrice, "Price Check Box");
		basetc_obj.tapOnElement(ReportClass.chkOther, "Other Check Box");
		basetc_obj.tapOnElement(ReportClass.btnReport, "Report Button");
		
		
    	//Validated Thank You For Your Feedback Banner
		basetc_obj.verifyPageIsDisplayed(SuggestEdit.imgGreen, "Thank You For Your Feeback Banner");
		
		
		//clicked on 3BHK List elements
		String actualBhk = basetc_obj.getElementAttribute(SearchResultPage.txtTitleProperty, "text");
		basetc_obj.tapOnElement(SuggestEdit.lstBhk, "BHK Type Drop Down List");
		if(actualBhk.contains("4+"))
			basetc_obj.tapOnElement(SuggestEdit.selectddl("3 BHK"), "3 BHK List");
		else if(actualBhk.contains("3"))
			basetc_obj.tapOnElement(SuggestEdit.selectddl("4 BHK"), "4 BHK List");
		else if(actualBhk.contains("2"))
			basetc_obj.tapOnElement(SuggestEdit.selectddl("4 BHK"), "4 BHK List");
		else if(actualBhk.contains("4 BHK"))
			basetc_obj.tapOnElement(SuggestEdit.selectddl("3 BHK"), "4 BHK List");
		else
			basetc_obj.tapOnElement(SuggestEdit.selectddl("4 BHK"), "4 BHK List");
	
		//Entered Note Edit Field 
		basetc_obj.swipeToText(SuggestEdit.btnAddNote, "text", "Add a note", 0.5, 0.8, 0.5, 0.2, 2);
		basetc_obj.inputText(SuggestEdit.btnAddNote, "Note Edit Field", PropertyHelper.helperProperty("password"));
		
		
		//clicked on Save Changed Button 
		basetc_obj.tapOnElement(SuggestEdit.btnSaved, "Save Changes Button");
		
		
		//Validated Thank you message
		basetc_obj.verifyPageIsDisplayed(SuggestEdit.txtThank, "Thank You Message Text");    	
    	}
	
	
	@AfterClass
	public void ClosingDriver() throws MalformedURLException
	{
		driver.close();
		driver.quit();
		test.pass("Driver got terminated successfully");
		
	}
	
	
	
}
