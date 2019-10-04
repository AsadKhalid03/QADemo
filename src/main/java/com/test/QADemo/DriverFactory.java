package com.test.QADemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private WebDriver driver;
	
	/**
	 * Getter & Setter functions for defined variable
	 */
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * It will set chrome property in the system and will open the browser with the given web link
	 */
	
	public void setupDriverAndBrowser(String webLink) {
		try {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(webLink);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			setDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * It will close the driver
	 */
	
	public void closeDriverAndBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
