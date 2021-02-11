package pages;

import org.openqa.selenium.By;

public class SuggestEdit {
	public static By imgGreen = By.id("com.nobroker.app:id/img_check");	
	public static By lstBhk = By.id("com.nobroker.app:id/sp_bhk_type");
	public static By selectddl(String text)
	{
		return By.xpath("//android.widget.TextView[@text='"+text+"']");
	}
	public static By btnSaved = By.id("com.nobroker.app:id/btn_save");
	public static By btnAddNote = By.id("com.nobroker.app:id/edt_others");
	public static By txtThank = By.id("com.nobroker.app:id/img_close");
}
