package org.sensiple.com.commons;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ResusableMethods extends TestBase {
	
	public static Logger logger=Logger.getLogger(new RuntimeException().getStackTrace()[1].getClassName());
	
	
	public static void implicitlyWait(){
		String time=configProp.getProperty("implicitWait");
		int timeUnit=Integer.parseInt(time);
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
	}
	
	public static void HighLightElement(WebElement element){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	
	public static void clear(String object){
		try {
			WebElement element=getElement(driver, objectProp.getProperty(object));
			if(element.isDisplayed()){
				HighLightElement(element);
				element.clear();
			logger.info("Cleared Input Field");	
			}else{
				logger.error("Unable to Clear Input Field");
		
			}
		} catch (Exception e) {
			logger.error(e);
		
		}
		
	}
	public static void enterText(String object,String data,String testStep){
		try {
		WebElement element=	getElement(driver, objectProp.getProperty(object));
	if(element.isDisplayed()){
		HighLightElement(element);
		element.sendKeys(data);
		takeScreenshot(testStep);
		logger.info("Entered Data in Input Field");
	}else{
		logger.error("Unable to Enter Data in Input Field");
	}
	
	
	
	
	} catch (Exception e) {
		logger.error(e);
	
	}

}
	
	
	
	public static void click(String object, String testStep){
		try {
		
	    WebElement element=	getElement(driver, objectProp.getProperty(object));
	if(element.isDisplayed() && element.isEnabled()){
		HighLightElement(element);
		takeScreenshot(testStep);
		element.click();
		
		logger.info("Clicked On WebElement");
	}else{
		logger.error("Unable to Click On WebElement");
	}
	} catch (Exception e) {
		logger.error(e);
	}
	}
	
	
	




	public static void verifyInputField(String object, String expected){
		try {
			 WebElement element=getElement(driver, objectProp.getProperty(object));
				if(element.isDisplayed()){
					HighLightElement(element);
					String actual=	element.getAttribute("value");
					Assert.assertEquals(actual, expected);
					logger.info("Actual is : :"+ actual + "Expected is : : " + expected);
					
				}else{
					logger.error("Actual is Not Equal to Expected");
						
					}
				
				
				
					
			
			
		} catch (Exception e) {
			logger.error(e);	
		}
	}
	
	
	public static void verifyText(String object, String expected){
		try {
			
			 WebElement element=getElement(driver, objectProp.getProperty(object));
				if(element.isDisplayed()){
					HighLightElement(element);
					String actual=	element.getText();
					Assert.assertEquals(actual, expected);
					logger.info("Actual is : :"+ actual + "Expected is : : " + expected);
					
				}else{
					logger.error("Actual is Not Equal to Expected");
						
					}
				
			
			
		} catch (Exception e) {
			logger.error(e);	
		}
		
	}
	
	
	
	public static void takeScreenshot(String testStep){

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    try
    {
        String destFile = "Reports/Project Screenshots/"
                + testStep+ "_screenshot.png";
        FileUtils.copyFile(scrFile, new File(destFile));
        //Reporter.log("[Console Log] Screenshot saved in " + testStep + "_screenshot.png");
    } catch (IOException ex)
    {
        // Log error message
    }
    
	}
	
	public static void verifyRadioButtonSelected(){
		
	}
	
	public static void verifyCheckBoxSelected(){
		
	}
	
	
	
	}
