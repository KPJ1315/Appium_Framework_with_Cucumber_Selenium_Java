package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SamplePageObj {
	AndroidDriver androidDriver;
	
	public SamplePageObj(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}

	public void openApp() {
		androidDriver.findElement(AppiumBy.accessibilityId("Docisn")).click();
		
	}

	public void setUserName(String mobileNo) {
		androidDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Mobile\"]")).sendKeys(mobileNo);
		
	}

	public void setPassword(String password) {
		androidDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Password\"]")).clear();
		androidDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Password\"]")).sendKeys(password);
	}

	public void clickLoginButton() {
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Sign In\"]")).click();
		
	}
	
	
	
	
	

}
