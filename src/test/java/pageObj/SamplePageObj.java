package pageObj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Helper;



public class SamplePageObj {
	AndroidDriver androidDriver;
	String filePath ="D:\\SeleniumP1\\JavaPractice\\FilePractice\\MyData.xlsx";
	String str ="Speciality";

	WebDriverWait wait;
	
	@AndroidFindBy(accessibility = "Docisn")
	WebElement clickApp;
	public SamplePageObj(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
	}	
	
	public void openApp() {
		try {
			Thread.sleep(9000);
			//			androidDriver.findElement(AppiumBy.accessibilityId("Docisn")).click();
			clickApp.click();
			Thread.sleep(2000);// to wait for the app to be clicked and open			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void setUserName(String mobileNo) {
		WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Mobile\"]")));
		userName.sendKeys(mobileNo);

	}

	public void setPassword(String password) {
		WebElement passWord = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@content-desc=\"pedit_fn_id\" and @text=\"Password\"]")));
		passWord.sendKeys(password);
	}

	public void clickLoginButton() {
		try{			
			WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Sign In\"]")));
			signIn.click();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectUser() {
		try {
			Thread.sleep(2000);
			WebElement userPic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@content-desc=\"home_prof_pic_id\"])[1]")));
			userPic.click();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logsOut() {
		try {
			Thread.sleep(2000);
			//click profile picture
			WebElement profilePic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"home_prof_pic_id\"]")));	
			profilePic.click();
			System.out.println("Profile pic clicked");
//			Thread.sleep(2000);
			
			//Click logou option
			
			
			WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Log Out\"]")));
			
			logOut.click();
//			androidDriver.findElement(By.xpath("")).click();

			//click logout
//			Thread.sleep(2000);
			
			WebElement clickLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")));
//			androidDriver.findElement(By.xpath()).click();
			clickLogout.click();
			androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickConsultation() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Consultation']")));
		element.click();
	}

	public void clickSeeMoreOfSpeciality() {
		WebElement	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.TextView[@text='See more'])[1]")));
		element.click();
	}

	public void searchTopSpeciality() {
		WebElement	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@content-desc='SearchSym_searchbar_id']")));
		element.sendKeys("General Practitioner");
		
//		String [] arrSpl = Helper.readExcelData(filePath, str);
//		for(String st : arrSpl) {		
//			element.sendKeys(st);	
//		}
	}

	public void verifySearchResult() {
		WebElement	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='General Practitioner']")));
		if(element.isDisplayed()) {
			System.out.println(element.getText());
		}
		WebElement backBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='󰁍']")));
		backBtn.click();		
		backBtn.click();
	}

	public void searcParticularSpeciality() {
		try {
		WebElement	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@content-desc='SearchSym_searchbar_id']")));
		element.sendKeys("Cardiology");
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Cardiology']")));
		ele.click();
		
		WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"\"]")));
		filter.click();
		
		Thread.sleep(2000);
		WebElement splty = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Speciality']")));
		splty.click();
		
		WebElement searchBarSpl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='Search speciality']")));
		searchBarSpl.clear();
		searchBarSpl.sendKeys("ENT");
//		String [] arrSpl = Helper.readExcelData(filePath, str);
//		for(String st : arrSpl) {		
//			searchBarSpl.sendKeys(st);	
//		}
		
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='']")).click(); //
		
		//back button
		
		WebElement bckButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='󰁍']")));
		bckButton.click();
//		wait.until(ExpectedConditions.visibilityOf(bckButton));
		Thread.sleep(3000);
		WebElement backBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='󰁍']")));
		backBtn.click();		
		backBtn.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
