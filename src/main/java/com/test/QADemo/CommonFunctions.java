package com.test.QADemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonFunctions {
	
	/**
	 * It will scroll and click on Web button
	 * @param driver
	 * @param selectorCSS
	 * @throws InterruptedException
	 */
	
	public void clickOnButton(WebDriver driver, String selectorCSS) throws InterruptedException {
		try {
			scrollElementIntoView(driver, selectorCSS);
			driver.findElement(By.cssSelector(selectorCSS)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * It will scroll and click on Web field
	 * @param driver
	 * @param selectorCSS
	 * @throws InterruptedException
	 */
	
	public void clickOnElement(WebDriver driver, String selectorCSS) throws InterruptedException {
		try {
			scrollElementIntoView(driver, selectorCSS);
			driver.findElement(By.cssSelector(selectorCSS)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * It will scroll and will return the value of field in a String
	 * @param driver
	 * @param selectorCSS
	 * @return
	 * @throws InterruptedException
	 */
	
	public String getElementValue(WebDriver driver, String selectorCSS) throws InterruptedException {
		String elmentValue = null;
		try {
			scrollElementIntoView(driver, selectorCSS);
			elmentValue = driver.findElement(By.cssSelector(selectorCSS)).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elmentValue;
	}
	
	/**
	 * It will scroll and check if the checkbox is not already selected and given value is "Yes" then it will select the checkbox
	 * @param driver
	 * @param selectorCSS
	 * @param value
	 * @throws InterruptedException
	 */
	
	public void selectElement(WebDriver driver, String selectorCSS, String value) throws InterruptedException {
		try {
			scrollElementIntoView(driver, selectorCSS);
			if (driver.findElement(By.cssSelector(selectorCSS)).isSelected() == false && value.equalsIgnoreCase("Yes")) {
				driver.findElement(By.cssSelector(selectorCSS)).click();
			} else {
				System.out.println("Selector is already selected, selector location is : " + selectorCSS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * It will run the date validation on a given date to see if the given date exists between two mentioned dates  
	 * @param userDate
	 * @return
	 * @throws InterruptedException
	 */
	
	public boolean stringToDateConverter(String userDate) throws InterruptedException {
		String [] dates = {"12/31/1929", "01/02/2000", userDate};
		Date minDate = null;
		Date maxDate = null;
		Date actualDate = null;
		try {
			DateFormat inputDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
			for (int index = 0; index < dates.length; index++) {
				Date formattedDate = (Date)inputDateFormatter.parse(dates[index]);
				if (index == 0) {
					minDate = formattedDate;
				} else if(index == 1) {
					maxDate = formattedDate;
				} else if (index == 2) {
					actualDate = formattedDate;
				}
			}	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(actualDate.after(minDate) && actualDate.before(maxDate)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * It will scroll any Web element
	 * @param driver
	 * @param selectorCSS
	 */
	
	public void scrollElementIntoView(WebDriver driver, String selectorCSS) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(selectorCSS)));
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -400)");
			waitUntilElementIsDisplayed(driver, selectorCSS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * It will write the given value in the respective field by using the given CSS
	 * Added sleep so user can see normally
	 * @param driver
	 * @param selectorCSS
	 * @param value
	 * @throws InterruptedException
	 */
	
	public void writeValue(WebDriver driver, String selectorCSS, String value) throws InterruptedException {
		try {
			driver.findElement(By.cssSelector(selectorCSS)).sendKeys(value);
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * It will wait for the element to show in the page
	 * @param driver
	 * @param selectorCSS
	 * @throws InterruptedException
	 */
	
	public void waitUntilElementIsDisplayed(WebDriver driver, final String selectorCSS) throws InterruptedException {		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(200)).ignoring(WebDriverException.class);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					if (driver.findElement(By.cssSelector(selectorCSS)).isEnabled() || driver.findElement(By.cssSelector(selectorCSS)).isDisplayed()) {
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		});
	}
	
	/**
	 * It will wait for data fetching spinner to go away
	 * @param driver
	 * @param selectorCSS
	 * @throws InterruptedException
	 */
	
	public void waitForElement(WebDriver driver, final String selectorCSS) throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(200)).ignoring(WebDriverException.class);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					if (driver.findElements(By.cssSelector(selectorCSS)).size() > 0) {
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		});
	}
}
