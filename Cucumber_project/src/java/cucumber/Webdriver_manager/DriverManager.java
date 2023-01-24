package com.cucumber.Webdriver_manager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.cucumber.constants.Constants;
import com.cucumber.utilities.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	static Logger logger = Logger.getLogger(DriverManager.class);

	private static WebDriver driver=null;

	public static WebDriver getDriver() {
		return driver;
	}
	public static void launchbrowser() {
		//lauching browser
		logger.info("Launching browser");
		try {
			switch (Constants.Browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				logger.info("Opening browser :"+Constants.Browser);
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				logger.info("Opening browser :"+Constants.Browser);
				driver = new FirefoxDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				logger.info("Opening browser :"+Constants.Browser);
				driver = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			CommonUtils.getInstance().takescreenshot();
			logger.info("Browser not opening");
		}
	}

}
