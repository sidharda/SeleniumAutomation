package org.sensiple.com.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {
	public static File configFile;
	public static FileInputStream configFis;
    public static Properties configProp;
    
    public static File objectFile;
    public static FileInputStream objectFis;
    public static Properties objectProp;
    
    public static File log4jFile;
    public static  FileInputStream log4jFis;
    
    public static WebDriver driver;
   
   
   
    
   public static Logger logger=Logger.getLogger(new RuntimeException().getStackTrace()[1].getClassName());
    
    
	
	public static void loadProjectConfigProperties(){
		
		configFile=new File("../SAFTest/src/test/java/org/sensiple/com/resources/projectConfig.properties");
		logger.info("Project Config Property File Loaded");
		try {
			 configFis=new FileInputStream(configFile);
			 configProp=new Properties();
			configProp.load(configFis);
		} catch (FileNotFoundException e) {
			logger.error("Project Config Property FIle Not Loaded" +e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
		
		
	}
	
	
	public static void loadObjectRepositoryProperties(){
		 objectFile=new File("../SAFTest/src/test/java/org/sensiple/com/resources/objectRepository.properties");
		 logger.info("Object Repository Property File Loaded");
		try {
			 objectFis=new FileInputStream(objectFile);
			 objectProp=new Properties();
			objectProp.load(objectFis);
		} catch (FileNotFoundException e) {
			logger.error("Object Repository Property FIle Not Loaded" +e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void loadLog4jProperties(){
		 log4jFile=new File("../SAFTest/src/test/java/org/sensiple/com/resources/log4j.properties");
		 logger.info("Log4j Property File Loaded");
		try {
			FileInputStream log4jFis=new FileInputStream(log4jFile);
			
		 PropertyConfigurator.configure(log4jFis);
	
		} catch (FileNotFoundException e) {
			logger.error("Log4j Property FIle Not Loaded" +e.getMessage());
			
			e.printStackTrace();
		
		}
		
		
		
	}
	
	
	public static void invokeBrowser(){
		String browser=configProp.getProperty("browser");
		
		
		logger.info("Browser is : : "+ browser);
		if(browser.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();
			logger.info("Firefox Browser Invoked");
			
		}else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "../SAFTest/Browsers/chromedriver.exe");
			driver=new ChromeDriver();
			logger.info("Chrome Browser Invoked");
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "../SAFTest/Browsers/IEDriverServer32.exe");
			driver=new InternetExplorerDriver();
			logger.info("Internet Explorer Browser Invoked");
			
		}else if(browser.equalsIgnoreCase("Safari")){
			driver=new SafariDriver();
			logger.info("Safari Browser Invoked");
			
		}else{
			logger.error("Browser Not Initialized");
		}
		driver.manage().window().maximize();
	}
	
	
	
	public static void initialization(){
		loadProjectConfigProperties();
		loadObjectRepositoryProperties();
		loadLog4jProperties();
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static WebElement getElement(WebDriver driver, String locator){
		String[] objects=locator.split("-->");
		
		String locatorType=objects[0];
		String locatorValue=objects[1];
		WebElement element = null;
		By by = null;
		
		
		if(locatorType.equalsIgnoreCase("className")){
			by=By.className(locatorValue);
			logger.info("Element Identified with ClassName : : " + by );  
		}else if(locatorType.equalsIgnoreCase("cssSel")){
			by=By.cssSelector(locatorValue);
			logger.info("Element Identified : : " + by );  
		}else if(locatorType.equalsIgnoreCase("id")){
			by=By.id(locatorValue);
			logger.info("Element Identified : : " + by );  
		}else if(locatorType.equalsIgnoreCase("lnkTxt")){
			by=By.linkText(locatorValue);
			
			logger.info("Element Identified : : " + by );  
	   }else if(locatorType.equalsIgnoreCase("name")){
			by=By.name(locatorValue);
			logger.info("Element Identified : : " + by );  
	   }else if(locatorType.equalsIgnoreCase("plLinkTxt")){
			by=By.partialLinkText(locatorValue);
			logger.info("Element Identified : : " + by );  
	   }else if(locatorType.equalsIgnoreCase("tagName")){
			by=By.tagName(locatorValue);
			logger.info("Element Identified : : " + by );  
	   }else if(locatorType.equalsIgnoreCase("Xpath")){
			by=By.xpath(locatorValue);
			logger.info("Element Identified : : " + by );  	
	   }else {
		   logger.error("Element not Identified");  
	   }
		
		
	  
		   if(driver.findElements(by).size()>0){
			   element =driver.findElement(by);
			  
			   
			   
				   
			    
			
				
		   }

		   return element;
	   }

}
