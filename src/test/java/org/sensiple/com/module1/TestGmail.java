package org.sensiple.com.module1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.sensiple.com.commons.ReusableMethods;
import org.sensiple.com.commons.TestBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class TestGmail extends TestBase{
	Logger logger=Logger.getLogger(TestGmail.class);
	
	@BeforeSuite
	public void setUp(){
		initialization();
		invokeBrowser();
		String url=TestBase.configProp.getProperty("baseUrl");
		logger.error("url is :: "+url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyUserLogin(){
		ReusableMethods.enterText("userName", "SensipleRavi");
		
		ReusableMethods.click("next","TC_VerifyUserLogin_02");
		
		ReusableMethods.enterText("password", "SensipleRavi");
		
		ReusableMethods.click("signIn", "TC_VerifyUserLogin_04");
		
	
		
		
	}
	
	@Test
	public void verifyHomepageTitle(){
		
		
		
	}
	@AfterSuite
	public void tearDown(){
		driver.close();
	}

}
