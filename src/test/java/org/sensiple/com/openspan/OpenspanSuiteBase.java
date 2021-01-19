package org.sensiple.com.openspan;

import org.apache.log4j.Logger;
import org.sensiple.com.commons.TestBase;

import org.sensiple.com.utils.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class OpenspanSuiteBase extends TestBase {

	public static Logger logger = Logger.getLogger(new RuntimeException().getStackTrace()[1].getClassName());

	@BeforeSuite
	public void checkSuiteSkip() {

		initialization();
		invokeBrowser();
		enterUrl();

		logger.debug("Checking Runmode of masterSuiteExcel");
		if (!TestUtil.verifyModuleExecutable(masterSuiteExcel, "OpenSpan")) {

			// System.out.println(Smoketestsuitexls.getRowCount("testcase"));
			logger.debug("Skipping the execution of Module1Suite as the runmode of the suite was set to NO");
			throw new SkipException(
					" RunMode of Module1Suite  is set to No, therefore skipping all test cases in Module1Suite");

		}

	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
