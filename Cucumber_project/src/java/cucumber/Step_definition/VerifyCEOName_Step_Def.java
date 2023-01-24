package com.cucumber.Step_definition;



import org.apache.log4j.Logger;

import com.cucumber.PageObjects.Dashboard_Page;
import com.cucumber.PageObjects.Directory_Page;

import com.cucumber.Webdriver_manager.DriverManager;

import com.cucumber.utilities.CommonUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyCEOName_Step_Def  {

	static Logger logger = Logger.getLogger(VerifyCEOName_Step_Def.class);

	@Given("^the user is logged in successfully and is on home page$")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() throws Throwable {
		logger.info("User successfully logged in to the Application");

		try {
			String currentUrl = DriverManager.getDriver().getCurrentUrl();

			if(currentUrl.contains("dashboard")) {
				logger.info("user is on Home page");
			}
			else {
				logger.info("user is not in Home page");
			}

		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}
	@When("^the clicks on the directory option from the menu bar$")
	public void the_clicks_on_the_directory_option_from_the_menu_bar() throws Throwable {

		try {
			Dashboard_Page.getInstance().clickDirectory();
			logger.info("User clicks on the Directory Option");
		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}

	@When("^the user selects the job title as Chief Executive Officer from the drop down$")
	public void the_user_selects_the_job_title_as_from_the_drop_down() throws Throwable {

		try {
			Directory_Page.getInstance().jobtitle();
			Directory_Page.getInstance().clickRole();
		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}

	@When("^clicks the search button$")
	public void clicks_the_search_button() throws Throwable {

		try {
			Directory_Page.getInstance().ClickSearch();
		}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}
	}

	@Then("^the user should see the ceo name as \"([^\"]*)\"$")
	public void the_user_should_see_the_ceo_name_as(String expectedName) throws Throwable {

		try {
			String Actualname = Directory_Page.getInstance().GetCEOName();

			if(Actualname.equalsIgnoreCase(expectedName)) {
				logger.info("Expected Name is seen");
			}
			else {
				logger.info("Expected Name is not seen");
			}}
		catch (Exception e) {
			logger.error(e);
			CommonUtils.getInstance().takescreenshot();
		}

	}}


