package com.cucumber.PageObjects;


import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.Webdriver_manager.DriverManager;

public class Directory_Page  {

	static Logger logger = Logger.getLogger(Directory_Page.class);

	//Singleton pattern

	private static Directory_Page  LoginInstance;
	private Directory_Page() {}
	public static Directory_Page  getInstance() {
		if(LoginInstance==null)
		{
			LoginInstance = new Directory_Page();
		}
		return LoginInstance;
	}
	public void jobtitle() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]"))).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}
	public void clickRole() {
		try {
			DriverManager.getDriver().findElement(By.xpath("//span[text()='Chief Executive Officer']")).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}
	public void ClickSearch() {
		try {
			DriverManager.getDriver().findElement(By.xpath("//button[text()=' Search ']")).click();
		}
		catch (Exception e) {
			logger.info("Element not found");
		}
	}

	public String GetCEOName() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(@class,'oxd-text oxd-text--p')])[1]"))).getText();
		}
		catch (Exception e) {
			logger.info("Element not found");
			return null;
		}

	}



}

