package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class SamplePageObj {
	AndroidDriver androidDriver;
	
	
	@AndroidFindBy(accessibility = "Docisn")
	WebElement clickApp;
	public SamplePageObj(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}

	public void openApp() {
		try {
			Thread.sleep(7000);
//			androidDriver.findElement(AppiumBy.accessibilityId("Docisn")).click();
			clickApp.click();
			Thread.sleep(2000);// to wait for the app to be clicked and open			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void setUserName(String mobileNo) {
		androidDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Mobile\"]")).sendKeys(mobileNo);
		
	}

	public void setPassword(String password) {
		androidDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Password\"]")).clear();
		androidDriver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Password\"]")).sendKeys(password);
	}

	public void clickLoginButton() {
		try{
			androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Sign In\"]")).click();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void selectUser() {
		androidDriver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"home_prof_pic_id\"])[1]")).click();		
	}

	public void logsOut() {
		try {
			Thread.sleep(2000);
		//click profile picture
		androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"home_prof_pic_id\"]")).click();
		System.out.println("Profile pic clicked");
		Thread.sleep(2000);
		//Click logou option
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Log Out\"]")).click();
		
		//click logout
		Thread.sleep(2000);
		androidDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();
		androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}	

}
