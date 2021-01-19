package org.sensiple.com.module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.sensiple.com.commons.ResusableMethods;
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
		ResusableMethods.enterText("userName", "SensipleRavi","TC_VerifyUserLogin_01");
		
		ResusableMethods.click("next","TC_VerifyUserLogin_02");
		
		ResusableMethods.enterText("password", "SensipleRavi", "TC_VerifyUserLogin_03");
		
		ResusableMethods.click("signIn", "TC_VerifyUserLogin_04");
		
	
		
		
	}
	
	@Test
	public void verifyHomepageTitle(){
		
		
		
	}
	@AfterSuite
	public void tearDown(){
		driver.close();
	}

}
