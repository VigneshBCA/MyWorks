package com.cucumber.PageObjects;


import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.Webdriver_manager.DriverManager;
import com.cucumber.constants.Constants;

public class LoginPage   {

	static Logger logger = Logger.getLogger(LoginPage.class);
	
	//Singleton pattern
	private static LoginPage  LoginInstance;
	private LoginPage() {}
	public static LoginPage  getInstance() {
		if(LoginInstance==null)
		{
			LoginInstance = new LoginPage();
		}
		return LoginInstance;
	}
	public void username(String Username) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(Constants.Username);;
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}
	public void password(String Password) {
		try {
			DriverManager.getDriver().findElement(By.name("password")).sendKeys(Constants.Password);
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}
	public void loginbutton() {
		try {
			DriverManager.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}
}
