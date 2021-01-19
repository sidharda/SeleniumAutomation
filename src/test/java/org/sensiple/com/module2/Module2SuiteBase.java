package org.sensiple.com.module2;



import org.apache.log4j.Logger;
import org.sensiple.com.commons.TestBase;
import org.sensiple.com.utils.TestSuiteExecution;
import org.sensiple.com.utils.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class Module2SuiteBase extends  TestBase{
	
	 public static Logger logger=Logger.getLogger(new RuntimeException().getStackTrace()[1].getClassName());
	
	@BeforeSuite
     public void checkSuiteSkip() throws Exception{ 
		
		
		logger.debug("Checking Runmode of suitexls");
	    if (!TestSuiteExecution.verifyModuleRunmode(masterSuiteExcel, "ModuleSuite"));
	    	
		{
	    	
			
			logger.debug("Skipping the execution of DemoModuleSuite as the runmode of the suite was set to NO");
			throw new SkipException(" RunMode of DemoModuleSuite  is set to No, therefore skipping all test cases in DemoModuleSuite");
			
		}

		}
		
		@AfterSuite
		public void tearDown(){
			driver.close();
		}

}
