package com.cucumber.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.Webdriver_manager.DriverManager;
import com.cucumber.constants.Constants;

public class CommonUtils {

	static Logger logger = Logger.getLogger(CommonUtils.class);

	private static CommonUtils  CommonUtilsInstance =null;

	//Singleton pattern
	private CommonUtils() {}
	public static CommonUtils  getInstance() {
		if(CommonUtilsInstance==null)
		{
			CommonUtilsInstance = new CommonUtils();
		}
		return CommonUtilsInstance;
	}

	// config file loader
	public  void loadproperties()   {

		Properties properties = new Properties();

		try {
			logger.info("Loading property File");
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			logger.error(e);
		}
		logger.info("Getting property Files");
		Constants.App_URL=	properties.getProperty("App_URL");
		Constants.Browser=	properties.getProperty("Browser");
		Constants.Username=	properties.getProperty("Username");
		Constants.Password=	properties.getProperty("Password");
	}
	public void takescreenshot() {

		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./screenshots/screenshot.png"));
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
