package com.cucumber.Step_definition;



import org.apache.log4j.Logger;

import com.cucumber.PageObjects.LoginPage;
import com.cucumber.Webdriver_manager.DriverManager;
import com.cucumber.constants.Constants;
import com.cucumber.utilities.CommonUtils;
import cucumber.api.java.Before;


public class Common_Step_Definition {

	static Logger logger = Logger.getLogger(Common_Step_Definition.class);

	// before method for opening browser
	@Before
	public void beforescenerio()   {

		try {
			CommonUtils.getInstance().loadproperties();

			if(DriverManager.getDriver()==null) {
				DriverManager.launchbrowser();
				Login();
			}}
		catch (Exception e) {
			logger.error(e);
		}
	}
	public void Login() throws InterruptedException   {
		//Launcing URL and Login to the Application
		logger.info("Launching the url");
		DriverManager.getDriver().get(Constants.App_URL);
		logger.info("Logging into OrangeHRM Application");
		LoginPage.getInstance().username(Constants.Username);
		LoginPage.getInstance().password(Constants.Password);
		LoginPage.getInstance().loginbutton();

	}
}
