package stepDef;

import java.net.MalformedURLException;

import baseclass.AppBase;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pageObj.SamplePageObj;

public class SampleStep {
	
	AndroidDriver androidDriver;
	AppBase baseClass;
	SamplePageObj pageObj;
	
	public SampleStep() throws MalformedURLException {
		baseClass=new AppBase();		
		androidDriver = baseClass.getDriver();
		pageObj = new SamplePageObj(androidDriver);
	}
	
	
	@Given("User clicks the app")
	public void user_clicks_the_app() {
	   pageObj.openApp();
	    
	}

	@Given("User enters login {string} & {string}")
	public void user_enters_login(String mobileNo, String password) {
	    pageObj.setUserName(mobileNo);
	    pageObj.setPassword(password);
	    
	}

	@Then("User clicks login button")
	public void user_clicks_login_button() {
	    pageObj.clickLoginButton();
	}



}
