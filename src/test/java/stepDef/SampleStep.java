
package stepDef;

import java.net.MalformedURLException;

import baseclass.AppBase;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
//			baseClass.startEmulator();
			baseClass.startAppiumServer();
			Thread.sleep(000);
			baseClass.initializeDriver();
			androidDriver = baseClass.getDriver();
			pageObj = new SamplePageObj(androidDriver);
			System.out.println("Appium driver initialized.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	@Given("User clicks the app")
	public void user_clicks_the_app() {
		try {
			pageObj.openApp();
			Thread.sleep(6000);
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
		System.out.println("User is logging out of app");
		pageObj.logsOut();

	}
	
	@When("User clicks consultation")
	public void user_clicks_consultation() {
	    pageObj.clickConsultation();
	    
	}

	@Then("User clicks see more of top speciality")
	public void user_clicks_see_more_of_top_speciality() {
		pageObj.clickSeeMoreOfSpeciality();
	    
	}

	@Then("User searches for a speciality by entering one in search bar")
	public void user_is_shown_the_speciality_on_entering_one_is_search_bar() {
		pageObj.searchTopSpeciality();
	    
	}
	
	@Then("User is shown search result")
	public void user_is_shown_search_result() {
	    pageObj.verifySearchResult();
	}
	
	@Then("User searches for a particular speciality in search bar")
	public void user_searches_for_a_particular_speciality_in_search_bar() {
		pageObj.searcParticularSpeciality();
	}



}
