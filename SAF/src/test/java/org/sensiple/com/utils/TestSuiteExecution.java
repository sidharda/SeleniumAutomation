package org.sensiple.com.utils;

public class TestSuiteExecution {

	
	
	public static boolean verifyModuleRunmode(ExcelHelper excel, String moduleName){
		
		boolean isExecutable=false;
		
		
		int rows=excel.getRowCount("Test Suite");
		
		for(int rowCount=2; rowCount<=rows; rowCount++){
			
			
			String module=excel.getCellData("Test Suite", "ModuleName", rows);
			
			String runmode=excel.getCellData("Test Suite", "Runmode", rows);
			
			if(module.equalsIgnoreCase(moduleName)){
				if(runmode.equalsIgnoreCase("Yes")){
					return isExecutable=true;
				}else if(runmode.equalsIgnoreCase("No")){
					return isExecutable=false;
				}
				}
			    }
		return isExecutable;
	}
	
	
	public static boolean verifyTestCaseRunmode(ExcelHelper excel, String testCaseName ){
		boolean isExecutable=false;
		
		
		int rows=excel.getRowCount("testCases");
		
		for(int rowCount=2; rowCount<rows; rowCount++){
		String tescase=	excel.getCellData("testCases","TestCaseName", rows);
		String runmode=excel.getCellData("Test Suite", "Runmode", rows);
		
		if(tescase.equalsIgnoreCase(testCaseName)){
			return isExecutable=true;
	
		}else if(runmode.equalsIgnoreCase("Yes")){
			return isExecutable=false;
			
		}
		
		}
		return isExecutable;
	    }
	
	
	
	
	
	
	
	}
