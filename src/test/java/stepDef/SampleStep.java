
package stepDef;

import java.net.MalformedURLException;

import baseclass.AppBase;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObj.SamplePageObj;

public class SampleStep {

	AndroidDriver androidDriver;
	AppBase baseClass;
	SamplePageObj pageObj;

	public SampleStep() {
		baseClass = new AppBase();
	}

	@Before
	public void setUp() throws MalformedURLException {
		try {
			baseClass.startEmulator();
			baseClass.startAppiumServer();
			Thread.sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseClass.initializeDriver();
		androidDriver = baseClass.getDriver();
		pageObj = new SamplePageObj(androidDriver);
		System.out.println("Appium driver initialized.");
	}


	@Given("User clicks the app")
	public void user_clicks_the_app() {
		try {
			Thread.sleep(5000);
			pageObj.openApp();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
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

	@When("User selects a app user, dashboard is displayed")
	public void user_selects_a_app_user_dashboard_is_displayed() {
		pageObj.selectUser();
	}

	@Then("User logsout of the app")
	public void user_logsout_of_the_app() {
		pageObj.logsOut();

	}



}
