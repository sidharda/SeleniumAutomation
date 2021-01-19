package org.sensiple.com.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sensiple.com.utils.ExcelHelper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExcel {
	static WebDriver driver;
	@BeforeTest
	public void setUp(){
		 driver=new FirefoxDriver();
		driver.get("http://gmail.com");
	}
	
	
	@Test
	public  void test1() {
		
		ExcelHelper excel=new ExcelHelper("../SAFTest/TestInputs/MasterSuite.xls");
		
		int rows=excel.getRowCount("Login");
		System.out.println(rows);
		for(int rowNum=2; rowNum<=rows; rowNum++){
			
			String username=excel.getCellData("Login", "Uname", rowNum);
			String password=excel.getCellData("Login", "Pword", rowNum);
			
			driver.findElement(By.id("Email")).sendKeys(username);
			
			driver.findElement(By.id("next")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			driver.findElement(By.id("Passwd")).sendKeys(password);
			driver.findElement(By.id("signIn")).click();
			String title=driver.getTitle();
			
			if(title.contains("Gmail1")){
				  excel.setCellData("Login", "Results", rowNum, "Pass");	
			}else{
				  excel.setCellData("Login", "Results", rowNum, "Fail");
			}
			
			System.out.println(username);
			System.out.println(password);
			
		 
		}
	}

}
