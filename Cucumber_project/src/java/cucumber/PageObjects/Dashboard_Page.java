package com.cucumber.PageObjects;


import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.Webdriver_manager.DriverManager;

public class Dashboard_Page  {

	static Logger logger = Logger.getLogger(Dashboard_Page.class);
	
	//Singleton pattern
	private static Dashboard_Page  LoginInstance;
	private Dashboard_Page() {}
	public static Dashboard_Page  getInstance() {
		if(LoginInstance==null)
		{
			LoginInstance = new Dashboard_Page();
		}
		return LoginInstance;
	}
	public void clickDirectory() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Directory']"))).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}}}
