package com.cucumber.PageObjects;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.Webdriver_manager.DriverManager;

public class Time_Option_Page {
	static Logger logger = Logger.getLogger(LoginPage.class);

	//Singleton pattern
	private static Time_Option_Page  LoginInstance;
	private Time_Option_Page() {}
	public static Time_Option_Page  getInstance() {
		if(LoginInstance==null)
		{
			LoginInstance = new Time_Option_Page();
		}
		return LoginInstance;
	}
	public void ClickTime() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Time']"))).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}

	}
	public void EnterName(String EmpName) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Employee Name']/following::input"))).sendKeys(EmpName);
		}
		catch (Exception e) {
			logger.info("Element not found");	
		}
	}
	public void ClickEmpName() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']"))).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}
	public void clickView() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}
	public String Getresult() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(@class,'oxd-text oxd-text--p')])[2]"))).getText();
		}
		catch (Exception e) {
			logger.info("Element not found");
			return null;
		}
	}
}
