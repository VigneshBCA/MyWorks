package com.cucumber.Step_definition;

import org.apache.log4j.Logger;

import com.cucumber.PageObjects.Time_Option_Page;
import com.cucumber.Webdriver_manager.DriverManager;
import com.cucumber.utilities.CommonUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VerifyTimesheets_Step_Def {
	static Logger logger = Logger.getLogger(VerifyTimesheets_Step_Def.class);

	@Given("^the user is on the homepage$")
	public void the_user_is_on_the_homepage() throws Throwable {

		try {
			String currentUrl = DriverManager.getDriver().getCurrentUrl();
			if(currentUrl.contains("dashboard")) {
				logger.info("user is on home page");
			}
			else {
				logger.info("user is not on home page");
			}
		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}

	@Given("^the user clicks on the time options from the menu$")
	public void the_user_clicks_on_the_time_options_from_the_menu() throws Throwable {

		try {
			Time_Option_Page.getInstance().ClickTime();
			logger.info("User clicks on Time option");
		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}

	@Given("^the user enters the name as \"([^\"]*)\"$")
	public void the_user_enters_the_name_as(String EmpName) throws Throwable {

		try {
			Time_Option_Page.getInstance().EnterName(EmpName);

			Time_Option_Page.getInstance().ClickEmpName();
		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}

	@Given("^clicks on the view button$")
	public void clicks_on_the_view_button() throws Throwable {

		try {
			Time_Option_Page.getInstance().clickView();
		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}

	@Then("^the user should see the message as \"([^\"]*)\"$")
	public void the_user_should_see_the_message_as(String expectedmessage) throws Throwable {
		Thread.sleep(2000);
		try {
			String getresult = Time_Option_Page.getInstance().Getresult();
			if(getresult.equalsIgnoreCase(expectedmessage)) 
				logger.info("Expected message is seen");
			else {
				logger.info("Expected message is not seen");
			}}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}
}
