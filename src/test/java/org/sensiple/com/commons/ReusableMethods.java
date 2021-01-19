package org.sensiple.com.commons;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ReusableMethods extends TestBase {

	public static Logger logger = Logger.getLogger(new RuntimeException().getStackTrace()[1].getClassName());

	public static void implicitlyWait() {
		String time = configProp.getProperty("implicitWait");
		int timeUnit = Integer.parseInt(time);
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
	}

	public static void HighLightElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid blue'", element);
	}

	public static void clear(String object) {
		try {
			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed()) {
				HighLightElement(element);
				element.clear();
				logger.info("Cleared Input Field");
			} else {
				logger.error("Unable to Clear Input Field");

			}
		} catch (Exception e) {
			logger.error(e);

		}

	}

	public static void enterText(String object, String data) {
		try {
			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed()) {
				HighLightElement(element);
				element.sendKeys(data);
				
				logger.info("Entered Data in Input Field");
			} else {
				logger.error("Unable to Enter Data in Input Field");
			}

		} catch (Exception e) {
			logger.error(e);

		}

	}
	
	

	public static void click(String object, String testStep) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed() && element.isEnabled()) {
				HighLightElement(element);
				takeScreenshot(testStep);
				element.click();

				logger.info("Clicked On WebElement");
			} else {
				logger.error("Unable to Click On WebElement");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	public static void perormMouseOver(String object) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed() && element.isEnabled()) {
				HighLightElement(element);
				Actions actions=new Actions(driver);
				actions.moveToElement(element).build().perform();

				logger.info("MouseOver Performed On WebElement");
			} else {
				logger.error("Unable to Perform Mouseover On WebElement");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public static void selectRadioButton(String object, String testStep) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed() && element.isEnabled()) {
				HighLightElement(element);
				takeScreenshot(testStep);
				element.click();

				logger.info("Selected Radio Button");
			} else {
				logger.error("Unable to Select Radio Button");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void selectCheckBox(String object, String testStep) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed() && element.isEnabled()) {
				HighLightElement(element);
				takeScreenshot(testStep);
				element.click();

				logger.info("Selected CheckBox Element");
			} else {
				logger.error("Unable to Select CheckBox Element");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void selectDropdownByIndex(String object, int option, String testStep) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed()) {
				HighLightElement(element);
				takeScreenshot(testStep);
				Select select = new Select(element);
				select.selectByIndex(option);

				logger.info("Selected Option from Dropdown");
			} else {
				logger.error("Unable to Select Option from Dropdown");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void selectDropdownByValue(String object, String option, String testStep) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed()) {
				HighLightElement(element);
				takeScreenshot(testStep);
				Select select = new Select(element);
				select.selectByValue(option);

				logger.info("Selected Option from Dropdown");
			} else {
				logger.error("Unable to Select Option from Dropdown");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void selectDropdownByVisibleText(String object, String option, String testStep) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));

			if (element.isDisplayed()) {
				HighLightElement(element);
				takeScreenshot(testStep);
				Select select = new Select(element);
				select.selectByValue(option);

				logger.info("Selected Option from Dropdown");
			} else {
				logger.error("Unable to Select Option from Dropdown");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void verifyInputField(String object, String expected) {
		try {
			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed()) {
				HighLightElement(element);
				String actual = element.getAttribute("value");
				Assert.assertEquals(actual, expected);
				logger.info("Actual is : :" + actual + "Expected is : : " + expected);

			} else {
				logger.error("Actual is Not Equal to Expected");

			}

		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void verifyText(String object, String expected) {
		try {

			WebElement element = getElement(driver, objectProp.getProperty(object));
			if (element.isDisplayed()) {
				HighLightElement(element);
				String actual = element.getText();
				Assert.assertEquals(actual, expected);
				logger.info("Actual is : :" + actual + "Expected is : : " + expected);

			} else {
				logger.error("Actual is Not Equal to Expected");

			}

		} catch (Exception e) {
			logger.error(e);
		}

	}

	public static void takeScreenshot(String testStep) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String destFile = "Reports/Project Screenshots/" + testStep + "_screenshot.png";
			FileUtils.copyFile(scrFile, new File(destFile));
			
		} catch (IOException ex) {
			
		}

	}

	public static void verifyRadioButtonSelected() {

	}

	public static void verifyCheckBoxSelected() {

	}

}
