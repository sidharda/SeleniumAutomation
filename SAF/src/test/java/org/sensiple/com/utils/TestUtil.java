package org.sensiple.com.utils;



public class TestUtil 
{
	
	
//Case 1:- Prepare function to check  Run mode of a  Suite - isSuiteRunnable	
	// find if the test suite is runnable......  where first test suite in Suite.xls is TestSuiteA
	public static boolean isSuiteRunnable(ExcelHelper excel,String suiteName)  //first test suite in Suite.xls is TestSuiteA
			
	{
	//finds if the test suite is runnable

	boolean isExecutable=false;
	for (int x=2; x<=excel.getRowCount("TestSuiteSheet"); x++)  // test sheet name is "TestSuiteSheet" in the file suite.xls
	  {
		System.out.println((excel.getCellData ("TestSuiteSheet", "TSID", x))+"------"+(excel.getCellData ("TestSuiteSheet", "Runmode", x)));
		
		String suite = excel.getCellData ("TestSuiteSheet", "TSID", x);
		String runmode = excel.getCellData ("TestSuiteSheet", "Runmode", x);

		if(suite.equals(suiteName))
		 {
		if(runmode.equalsIgnoreCase("Y"))
			{
			isExecutable=true;
			}
		else if(runmode.equalsIgnoreCase("N"))
			{
			isExecutable = false;
			}

	     }
	  }
	excel=null;
	return isExecutable ;
	}
	
 // up to this.... to get the run mode equals to true or false-------------

//-----------------------------------------------------------------------------------
	
//Case 2:-	Prepare function to check Run mode of a com.selenium.CodeManagement Case in com.selenium.CodeManagement Suite - isTestCaseRunnable
	
//returns true if run mode of the test case is equals to "y"
	//pre- requisits:
	//provide path of the TestSuiteA.xls File as --> Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+ "\\src\\com\\selenium\\xls\\TestSuiteA.xls");  
    //it returns "true" if the "Runmode" of the testCaseName ("TestCaseA3") available in the testSuite ("TestSuiteA.xls")
	
public static boolean isTestCaseRunnable(ExcelHelper excel,String testCaseName){
	  
	boolean isExecutable=false;
	//  in TestSuiteA.xls and TestSuiteB.xls should have sheet name consistent as testcase
	for (int x=2; x<=excel.getRowCount("testcase"); x++)
	{
		System.out.println((excel.getCellData ("testcase","TCID",x))+"------"+(excel.getCellData ("testcase","Runmode",x)));
				
		if(excel.getCellData("testcase","TCID",x).equalsIgnoreCase(testCaseName))
		{
			if (excel.getCellData("testcase","Runmode",x).equalsIgnoreCase("Y"))
			{
				isExecutable=true;
			}
			else if(excel.getCellData("testcase","Runmode",x).equalsIgnoreCase("N"))
			{
				isExecutable=false;	
			}	
		
		}
	}
	
	return isExecutable;
	}


//Provide the corresponding testcaseSheet name available in the testCaseName --> ("TestCaseA3") available in the testSuite ("TestSuiteA.xls") 
public static Object[][] getdata(ExcelHelper excel,String testCaseName)  // from the excel sheet with test sheet name = TestcaseName
{


	if( excel.isSheetExist(testCaseName))  // if sheet with same name "TestCaseName" doesn't exists then this function will return [! false] which is true and therefore go inside the if loop )
				{
					excel=null;  // for memory clean up
					return new Object[1][0];   // and it returns and object array with one row and zero column will return  i.e hypothetical array.
					                            // we are making sure that atleast once the test will execute
				
				}


	
int rows = excel.getRowCount(testCaseName);  				 
int columns = excel.getColumnCount(testCaseName);


 Object[][] data =new Object[rows-1][columns-1];
// extract data from cell
 for (int rowNum =2;rowNum<= rows;rowNum++)
	{
		for (int ColNum =2;ColNum<= columns;ColNum++)
		{
		
			data[rowNum][ColNum]= excel.getCellData(testCaseName, ColNum, rowNum); 
	}
		
}
	
 return data;


}



// up to this to.... return the test data from a test in 2 dimensional (nxn) array

//--------------------------------------------------------
//case 4:
// Make a function to Check the runmode for datasets

public static String[] getDataSetRunmodes (ExcelHelper excel,String sheetName)
	{
	String[]Runmode= null;
		if(!excel.isSheetExist(sheetName))	
		{
			excel=null;
			sheetName=null;
			Runmode = new String [2];
			Runmode[0]= "Y";
			Runmode[1]= "N";
			
			excel=null;
			sheetName=null;
			return Runmode;
		}
		Runmode= new String [excel.getRowCount(sheetName)-1] ;
	for(int i = 2; i<=Runmode.length+1;i++)
		{
		Runmode[i-2]= excel.getCellData(sheetName, "Runmode", i);
		
		}
		excel=null;
		sheetName=null;
		return Runmode;
	}





//up to this to.... check the runmode for datasets
//--------------------------------------------------------
//case 5:
//Make a function to Update the Results column in testCaseName sheet - reportTestResult


//Update Results for a particular dataset 
public static void reportTestResult(ExcelHelper excel, String testCaseName, int rowNum, String Results)
				{
				excel.setCellData("testcase", "Results", rowNum, Results);
				}	




//up to this to.... to update the "Results" column in testcasesheet
//----------------------------------------------------------------------------

// case 6:
//Make a function to Update the result column in data sheet - reportDataSetResult


//Update Results for a particular dataset 
public static void reportDataSetResult(ExcelHelper excel, String testCaseName, int rowNum, String Results)
				{	
				excel.setCellData(testCaseName,"Results",rowNum,Results);
				}	




//up to this to.... to update the "Results" column in testcase sheet
//----------------------------------------------------------------------------


// case 7:

// return the row number for a test

public static int getRowNum(ExcelHelper excel,String id)
  {
	for (int x=2; x<=excel.getRowCount("testcase"); x++)
		{
		String tcid = excel.getCellData("testcase","TCID",x);
		
		if(tcid.equalsIgnoreCase(id))
			{
			excel= null;
			return x;
			}
		}

	return -1;
  }

}

//up to this to.... to update the "Results" column in testcasesheet
//----------------------------------------------------------------------------



