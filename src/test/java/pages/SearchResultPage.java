package pages;

import org.openqa.selenium.By;

import generic.BaseTestClass;
import helper.PropertyHelper;
import utility.Base;


public class SearchResultPage extends Base{
	public static By txtLoad = By.id("com.nobroker.app:id/property_list_result");	
	public static By pgSearch = By.id("com.nobroker.app:id/rv");
	public static By imgThumbnail = By.id("com.nobroker.app:id/property_thumbnail");
	public static By btnOwnerContact = By.id("com.nobroker.app:id/contactOwnerInDetail");
	public static By txtWrongInfo = By.id("com.nobroker.app:id/tv_report_wrong_info");
	public static By txtTitleProperty = By.id("com.nobroker.app:id/basic_info_title");
	public static By txtPropertyStatus = By.id("com.nobroker.app:id/filterPropertyStatusText");
	public static By edtSearchLocations = By.id("com.nobroker.app:id/localityAutoCompleteTxt");
	public static By lstFirstEntry = By.id("com.nobroker.app:id/logo");
	public static By chkIncludeNearByProperties = By.id("com.nobroker.app:id/nearByRadio");
	public static By ttlHome = By.id("com.nobroker.app:id/homeTitle");
	public static By lstBoxPlaces = By.id("com.nobroker.app:id/spinnergo");
	
	
	public static void enterText(String inputtext) throws Exception
	{
		driver.findElement(edtSearchLocations).sendKeys(PropertyHelper.helperProperty(inputtext));
	}
	
	
	
	
	public static void checkboxmethod() throws Exception
	{
		
		driver.findElement(chkIncludeNearByProperties).click();
	}

	

	
}
