package org.sensiple.com.openspan;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.sensiple.com.commons.ReusableMethods;
import org.sensiple.com.utils.TestUtil;
import org.testng.SkipException;

public class VerifyUserLogin extends OpenspanSuiteBase {

	static int count = 1;
	static boolean pass = false;
	static boolean fail = false;
	static boolean skip = false;
	static boolean isTestPass = true;

	public static Logger logger = Logger.getLogger(new RuntimeException().getStackTrace()[1].getClassName());

	@BeforeTest
	public void checkTestSkip() {

		if (!TestUtil.verifyTestCaseExecutable(openspanSuiteExcel, this.getClass().getSimpleName())) {
			logger.info("Skipping execution of" + this.getClass().getSimpleName()
					+ " because runmode of test case set to NO "); 
			throw new SkipException("Skipping execution of" + this.getClass().getSimpleName()
					+ " because runmode of test case set to NO "); 
		}

	}

	@Test(dataProvider = "getTestData")
	public void createNewUser(String username, String password) {

		count++;

		System.out.println("Executing " + this.getClass().getSimpleName() + ".....");
		logger.debug("Executing " + this.getClass().getSimpleName() + ".....");

		try {
			enterUrl();
ReusableMethods.enterText("username", username);

ReusableMethods.enterText("password", password);
ReusableMethods.click("signIn", "SignIn Button");

		} catch (Throwable t) {
			logger.error(t.getMessage());

		}

	}

	@AfterTest
	public void reportTestResult() {

		if (isTestPass) {
			TestUtil.reportTestResult(openspanSuiteExcel, this.getClass().getSimpleName(),
					TestUtil.getRowNum(openspanSuiteExcel, this.getClass().getSimpleName()), "Pass");
		} else {
			TestUtil.reportTestResult(openspanSuiteExcel, this.getClass().getSimpleName(),
					TestUtil.getRowNum(openspanSuiteExcel, this.getClass().getSimpleName()), "Fail");

		}

	}

	@DataProvider

	public Object[][] getTestData() {
		return TestUtil.getdata(openspanSuiteExcel, this.getClass().getSimpleName());

	}

}
