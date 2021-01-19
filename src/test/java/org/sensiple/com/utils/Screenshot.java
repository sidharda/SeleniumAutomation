package org.sensiple.com.utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
 	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm");
 		public static void Screencapture(String MethodName,WebDriver driver1){
        
 			String d = dateFormat.format(new Date()).toString();
 			System.out.println(d);
 			System.out.println("Screenshot - Screenshot() -Test_Case Step :" + MethodName);
	 File scrFile = (File) ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
	  try {
		  FileUtils.copyFile(scrFile, new File("./Project_ScreenShots/"+MethodName+".png"));
	  } catch (IOException e) {
	  	e.printStackTrace();
	  }	                     
    }
 		
public static void Folder_Creation(String MethodName){
	
	 String strManyDirectories="Project_ScreenShots/" + MethodName;
	 try{
	 boolean success = (new File(strManyDirectories)).mkdirs();
	 
	  if (success) {
	  System.out.println("Screenshot - Folder_Creation() - Directories: " + strManyDirectories + " created");
	  }

	  }catch (Exception e){
	  System.err.println("Error: " + e.getMessage());
	  }
	
}

public static void main(String[] args) throws IOException {
//		WriteFile test = new WriteFile(path);
		Folder_Creation("hello");
	}
}


