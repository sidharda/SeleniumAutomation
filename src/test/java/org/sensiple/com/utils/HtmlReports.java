package org.sensiple.com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class HtmlReports {

	public static FileWriter fw = null;
	public static PrintWriter pw = null;
	public static FileWriter ofw = null;
	public static PrintWriter opw = null;
	public static Calendar currentDate = Calendar.getInstance();
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
	private static String TC_Steps = null;
	private static String ScreenShot = "ScreenShot";

	// Colour Setting Variable.
	static String color = "#153E7E";
	static String fontface = "Geneva, Arial";
	static String Table_font_Color = "#ffffff";
	static String Content_font_Color = "#153E7E";
	static String Heading_font_Color = "#400080";
	static String ModuleName_font_color = "#ff0080";
	static String AutomationTestResults_font_color = "#000080";
	static int Test_Steps = 1;

	// Module Report Header Column Variable.
	static String Module_Column_One;
	static String Module_Column_Two;
	static String Module_Column_Three;
	static String Module_Column_Four;
	static String Module_Column_Five;

	// OverView Report Header Column Variable.
	static String OverView_Column_One;
	static String OverView_Column_Two;
	static String OverView_Column_Three;
	static String OverView_Column_Four;
	static String OverView_Column_Five;
	static String OverView_Column_Six;

	// ScreenShot Variable.
	static String ScreenShot_Error;
	public static String ScreenShotFor_EveryStep;
	public static boolean ScreenShot_EveryStep = true;
	public static boolean ScreenShot_Cond;

	// OverView Report Header Column Variable.
	static String Executed_By;
	static String Tool_Name;
	static String Tool_Version;
	static String Application_Name;
	static String Company_Name;
	static String Region;
	static String Platform;

	public static void main(String aa[]) throws Exception {
		close();
	}

	public static void Setting_Header_Values() {
		Properties prop;
		prop = new Properties();
		String filePath = "../SAFTest/TestReports";
		try {
			prop.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("No Properties file found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error loading properties file");
			e.printStackTrace();
		}

		ScreenShot_Error = prop.getProperty("ScreenShot_Error").trim();
		ScreenShotFor_EveryStep = prop.getProperty("ScreenShot_EveryStep").trim();

		Module_Column_One = prop.getProperty("Module_Column_One").trim();
		Module_Column_Two = prop.getProperty("Module_Column_Two").trim();
		Module_Column_Three = prop.getProperty("Module_Column_Three").trim();
		Module_Column_Four = prop.getProperty("Module_Column_Four").trim();
		Module_Column_Five = prop.getProperty("Module_Column_Five").trim();
		OverView_Column_One = prop.getProperty("OverView_Column_One").trim();
		OverView_Column_Two = prop.getProperty("OverView_Column_Two").trim();
		OverView_Column_Three = prop.getProperty("OverView_Column_Three").trim();
		OverView_Column_Four = prop.getProperty("OverView_Column_Four").trim();
		OverView_Column_Five = prop.getProperty("OverView_Column_Five").trim();
		OverView_Column_Six = prop.getProperty("OverView_Column_Six").trim();

		Executed_By = prop.getProperty("Executed_By").trim();
		Tool_Name = prop.getProperty("Tool_Name").trim();
		Tool_Version = prop.getProperty("Tool_Version").trim();
		Application_Name = prop.getProperty("Application_Name").trim();
		Company_Name = prop.getProperty("Company_Name").trim();
		Region = prop.getProperty("Region").trim();
		Platform = prop.getProperty("Platform").trim();

		// ScreenShot Deciding Part:
		if (ScreenShot_Error.equalsIgnoreCase("Yes") && ScreenShotFor_EveryStep.equalsIgnoreCase("Yes")) {
			ScreenShot_Cond = false;
		} else {
			ScreenShot_Cond = true;
		}

		if (ScreenShotFor_EveryStep.equalsIgnoreCase("No")) {
			ScreenShot_EveryStep = false;
		}

	}

	// **********************Individual Modules
	// Report:******************************

	public static void reporting(String name) throws Exception {

		System.out.println("Inside Report");

		if (ScreenShot_Cond && ScreenShot_EveryStep) {

			System.out.println("Inside If Part of reporting");
			fw = new FileWriter("./TestReports/" + name + ".html");
			pw = new PrintWriter(fw);
			pw.println("<title>" + name + "</title>");
			pw.println("<head><h4><font color=" + Heading_font_Color + ">Detailed Report: " + name
					+ " Module</font></h4></head>");
			pw.println("<TABLE BORDER><TR bgcolor=" + color + "><TH><FONT COLOR=" + Table_font_Color + "FACE="
					+ fontface + "SIZE=" + 6 + ">" + Module_Column_One + "</font><TH><FONT COLOR=" + Table_font_Color
					+ "FACE=" + fontface + "SIZE=" + 6 + ">" + Module_Column_Two + "</font><TH><FONT COLOR="
					+ Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">" + Module_Column_Three
					+ "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">"
					+ Module_Column_Four + "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface + "SIZE="
					+ 6 + ">" + Module_Column_Five + "</font></TR>");
			pw.close();
		} else {

			System.out.println("Inside Else Part of reporting");
			fw = new FileWriter("./TestReports/" + name + ".html");
			pw = new PrintWriter(fw);
			pw.println("<title>" + name + "</title>");
			pw.println("<head><h4><font color=" + Heading_font_Color + ">Detailed Report: " + name
					+ " Module</font></h4></head>");
			pw.println("<TABLE BORDER><TR bgcolor=" + color + "><TH><FONT COLOR=" + Table_font_Color + "FACE="
					+ fontface + "SIZE=" + 6 + ">" + Module_Column_One + "</font><TH><FONT COLOR=" + Table_font_Color
					+ "FACE=" + fontface + "SIZE=" + 6 + ">" + Module_Column_Two + "</font><TH><FONT COLOR="
					+ Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">" + Module_Column_Three
					+ "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">"
					+ Module_Column_Four + "</font></TR>");
			pw.close();
		}
	}

	public static PrintWriter fileObjectReport(String name) throws Exception {
		File f = new File("./TestReports/" + name + ".html");
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		return pw;
	}

	public static void assertionColumnReport(PrintWriter pw, String methodName) {
		if (ScreenShot_Cond && ScreenShot_EveryStep) {

			System.out.println("Inside If Part of assertionColumnReport");
			pw.println("<TR>");
			pw.println("<TD colspan=" + 5 + " align=" + "center" + "><font color=" + ModuleName_font_color + ">"
					+ methodName + "</font></TD></TR>");
			HtmlReports.Test_Steps = 1;
		} else {

			System.out.println("Inside Else Part of assertionColumnReport");
			pw.println("<TR>");
			pw.println("<TD colspan=" + 4 + " align=" + "center" + "><font color=" + ModuleName_font_color + ">"
					+ methodName + "</font></TD></TR>");
			HtmlReports.Test_Steps = 1;
		}
	}

	public static void assertionValues(PrintWriter pw, String Tc_Steps, String Status, WebDriver driver) {
		TC_Steps = Tc_Steps;
		System.out.println("TC_Steps: " + TC_Steps);
		System.out.println("Inside assertionValues");

		if (ScreenShot_Cond && ScreenShot_EveryStep) {

			System.out.println("Inside If Part of assertionValues");
			pw.println("<TR><TD align=" + "center" + "><font color=" + Content_font_Color + ">" + "TS" + Test_Steps
					+ "<TD align=" + "center" + "><font color=" + Content_font_Color + ">" + Tc_Steps
					+ "</font><TD width=55% align=" + "center" + "><font color=" + Content_font_Color + ">" + Status);
			System.out.println("Inside assertionValues1");
			Screenshot.Screencapture(Tc_Steps, driver);
			Test_Steps = Test_Steps + 1;
		} else {

			System.out.println("Inside Else Part of assertionValues");
			pw.println("<TR><TD align=" + "center" + "><font color=" + Content_font_Color + ">" + "TS" + Test_Steps
					+ "<TD align=" + "center" + "><font color=" + Content_font_Color + ">" + Tc_Steps
					+ "</font><TD width=55% align=" + "center" + "><font color=" + Content_font_Color + ">" + Status);
			System.out.println("Inside assertionValues1");
			Test_Steps = Test_Steps + 1;
		}
	}

	public static void CompareValues(PrintWriter pw, String Status) {
		pw.println("<TR><TD width=100%>" + Status + "</TR>");
		System.out.println("Report : assertionValues");
	}

	public static void assertionPassStatus(PrintWriter pw, String PassStatus) {
		System.out.println("Inside assertionPassStatus");

		if (ScreenShot_Cond && ScreenShot_EveryStep) {

			System.out.println("Inside If Part of assertionPassStatus");
			if (PassStatus.equalsIgnoreCase("Pass")) {
				pw.println("</font><TD bgcolor = #80ff00 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Pass" + "</font><TD align=" + "center"
						+ "><a href=file://C:/workspace/Ravi/AutomationProjectDemo/Project_ScreenShots/" + TC_Steps
						+ ".png><font color=" + Content_font_Color + ">" + ScreenShot + "</a></font>");

			} else {
				pw.println("</font><TD bgcolor = #ff0000 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Fail" + "</font><TD align=" + "center"
						+ "><a href=file://C:/workspace/Ravi/AutomationProjectDemo/Project_ScreenShots/" + TC_Steps
						+ ".png><font color=" + Content_font_Color + ">" + ScreenShot + "</a></font>");
				AssertJUnit.assertEquals("", true, false);
			}
		} else {

			System.out.println("Inside Else Part of assertionPassStatus");
			if (PassStatus.equalsIgnoreCase("Pass")) {
				pw.println("</font><TD bgcolor = #80ff00 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Pass" + "</font>");

			} else {
				pw.println("</font><TD bgcolor = #ff0000 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Fail" + "</font>");
				AssertJUnit.assertEquals("", true, false);
			}
		}
	}

	public static void assertionPassStatus_Verify(PrintWriter pw, String PassStatus) {
		System.out.println("Inside assertionPassStatus");

		if (ScreenShot_Cond && ScreenShot_EveryStep) {

			System.out.println("Inside If Part of assertionPassStatus");
			if (PassStatus.equalsIgnoreCase("Pass")) {
				pw.println("</font><TD bgcolor = #80ff00 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Pass" + "</font><TD align=" + "center"
						+ "><a href=file:///C:/workspace/Ravi/AutomationProjectDemo/Project_ScreenShots/" + TC_Steps
						+ ".png><font color=" + Content_font_Color + ">" + ScreenShot + "</a></font>");

			} else {
				pw.println("</font><TD bgcolor = #ff0000 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Fail" + "</font><TD align=" + "center"
						+ "><a href=file:///C:/workspace/Ravi/AutomationProjectDemo/Project_ScreenShots/" + TC_Steps
						+ ".png><font color=" + Content_font_Color + ">" + ScreenShot + "</a></font>");
				// AssertJUnit.assertEquals("", true, false);
			}
		} else {

			System.out.println("Inside Else Part of assertionPassStatus");
			if (PassStatus.equalsIgnoreCase("Pass")) {
				pw.println("</font><TD bgcolor = #80ff00 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Pass" + "</font>");

			} else {
				pw.println("</font><TD bgcolor = #ff0000 align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ "Fail" + "</font>");
				// AssertJUnit.assertEquals("", true, false);
			}
		}
	}

	public static void statusUpdate(PrintWriter pw, boolean test, String Status, Date executionTime) {
		pw.close();
	}

	public static void close() {
		pw.println("</TABLE>");
		pw.close();
	}

	// ******************Overall Reports for All Module with
	// Description:*****************************

	public static void OverViewreportingTitle() throws Exception {
		System.out.println("Inside OverViewreportingTitle");

		String Executer_Name = null;
		Executer_Name = "Mani";

		System.out.println("Inside Report");
		ofw = new FileWriter("./TestReports/ReportsOverview.html");
		opw = new PrintWriter(fw);
		opw.println("<TABLE Border width=100%><TR><TH>Test Case Name :" + currentDate.getTime() + "<TH>"
				+ "<table width=100%><tr><td>Executed By</td><td> : " + Executer_Name + "</td></tr>"
				+ "<tr><td>Tool Name</td><td> : Selenium</td></tr>" + "<tr><td>Tool Version</td><td> : 2.0</td></tr>"
				+ "<tr><td>Application Name</td><td> : Angel</td></tr>"
				+ "<tr><td>Company Name</td><td> : Sensiple</td></tr>" + "<tr><td>Region</td><td> : Chennai</td></tr>"
				+ "<tr><td>Platform</td><td> : MS Windows 7 Professional</td></tr>" + "</table></TR></table>");
		opw.close();
	}

	public static void OverViewreporting() throws Exception {
		System.out.println("Inside OverViewreporting");
		@SuppressWarnings("unused")
		String Executer_Name = "E*Pro";

		if (ScreenShot_Cond) {

			System.out.println("Inside If Part of OverViewreporting");
			ofw = new FileWriter("./TestReports/ReportsOverview.html");
			opw = new PrintWriter(ofw);
			opw.println("<title>Detailed Report OverView</title>");
			opw.println("<head><h2 align=" + "center" + "><font color=" + AutomationTestResults_font_color
					+ ">Automation Test Results</font></h2></head>");
			opw.println("<h4><font color=" + Heading_font_Color + ">Test Details: </font></h4>");
			opw.println("<TABLE Border><TR><TH bgcolor= #153E7E ><FONT COLOR=" + Table_font_Color + "FACE=" + fontface
					+ "SIZE=" + 6 + ">Execution Date & Time :" + currentDate.getTime() + "</font><TH>"
					+ "<table ><tr><td><font color=" + Content_font_Color + ">Executed By</font></td><td><font color="
					+ Content_font_Color + "> : " + Executed_By + "</font></td></tr>" + "<tr><td><font color="
					+ Content_font_Color + ">Tool Name</font></td><td><font color=" + Content_font_Color + "> : "
					+ Tool_Name + "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Tool Version</font></td><td><font color=" + Content_font_Color + "> : " + Tool_Version
					+ "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Application Name</font></td><td><font color=" + Content_font_Color + "> : " + Application_Name
					+ "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Company Name</font></td><td><font color=" + Content_font_Color + "> : " + Company_Name
					+ "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Region</font></td><td><font color=" + Content_font_Color + "> : " + Region + "</font></td></tr>"
					+ "<tr><td><font color=" + Content_font_Color + ">Platform</font></td><td><font color="
					+ Content_font_Color + "> : " + Platform + "</font></td></tr>"
					+ "<tr></tr><tr></tr></table></TR></table>");
			opw.println("<TABLE BORDER><TR bgcolor=" + color + "><TH><FONT COLOR=" + Table_font_Color + "FACE="
					+ fontface + "SIZE=" + 6 + ">" + OverView_Column_One + "</font><TH><FONT COLOR=" + Table_font_Color
					+ "FACE=" + fontface + "SIZE=" + 6 + ">" + OverView_Column_Two + "</font><TH><FONT COLOR="
					+ Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">" + OverView_Column_Three
					+ "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">"
					+ OverView_Column_Four + "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface + "SIZE="
					+ 6 + ">" + OverView_Column_Five + "</font></TR>");
			opw.close();
		} else {

			System.out.println("Inside Else Part of OverViewreporting");
			ofw = new FileWriter("./TestReports/ReportsOverview.html");
			opw = new PrintWriter(ofw);
			opw.println("<title>Detailed Report OverView</title>");
			opw.println("<head><h2 align=" + "center" + "><font color=" + AutomationTestResults_font_color
					+ ">Automation Test Results</font></h2></head>");
			opw.println("<h4><font color=" + Heading_font_Color + ">Test Details: </font></h4>");
			opw.println("<TABLE Border><TR><TH bgcolor= #153E7E ><FONT COLOR=" + Table_font_Color + "FACE=" + fontface
					+ "SIZE=" + 6 + ">Test Case Name :" + currentDate.getTime() + "</font><TH>"
					+ "<table ><tr><td><font color=" + Content_font_Color + ">Executed By</font></td><td><font color="
					+ Content_font_Color + "> : " + Executed_By + "</font></td></tr>" + "<tr><td><font color="
					+ Content_font_Color + ">Tool Name</font></td><td><font color=" + Content_font_Color + "> : "
					+ Tool_Name + "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Tool Version</font></td><td><font color=" + Content_font_Color + "> : " + Tool_Version
					+ "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Application Name</font></td><td><font color=" + Content_font_Color + "> : " + Application_Name
					+ "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Company Name</font></td><td><font color=" + Content_font_Color + "> : " + Company_Name
					+ "</font></td></tr>" + "<tr><td><font color=" + Content_font_Color
					+ ">Region</font></td><td><font color=" + Content_font_Color + "> : " + Region + "</font></td></tr>"
					+ "<tr><td><font color=" + Content_font_Color + ">Platform</font></td><td><font color="
					+ Content_font_Color + "> : " + Platform + "</font></td></tr>"
					+ "<tr></tr><tr></tr></table></TR></table>");
			opw.println("<TABLE BORDER><TR bgcolor=" + color + "><TH><FONT COLOR=" + Table_font_Color + "FACE="
					+ fontface + "SIZE=" + 6 + ">" + OverView_Column_One + "</font><TH><FONT COLOR=" + Table_font_Color
					+ "FACE=" + fontface + "SIZE=" + 6 + ">" + OverView_Column_Two + "</font><TH><FONT COLOR="
					+ Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">" + OverView_Column_Three
					+ "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface + "SIZE=" + 6 + ">"
					+ OverView_Column_Four + "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface + "SIZE="
					+ 6 + ">" + OverView_Column_Five + "</font><TH><FONT COLOR=" + Table_font_Color + "FACE=" + fontface
					+ "SIZE=" + 6 + ">" + OverView_Column_Six + "</font></TR>");
			opw.close();
		}
	}

	public static PrintWriter OverviewfileObjectReport() throws Exception {
		File f = new File("./TestReports/ReportsOverview.html");
		FileWriter ofw = new FileWriter(f, true);
		PrintWriter opw = new PrintWriter(ofw);
		return opw;
	}

	public static void OverViewModuleReport(PrintWriter opw, String ModuleName) throws IOException {
		System.out.println("Inside OverViewModuleReport");
		System.out.println("ModuleName :" + ModuleName);

		if (ScreenShot_Cond) {

			System.out.println("Inside If Part of OverViewModuleReport");
			opw.println("<TR>");
			opw.println("<TD colspan=" + 5 + " align=" + "center" + "><font color=" + ModuleName_font_color
					+ "><a href=file://C:/workspace/Ravi/AutomationProjectDemo/TestReports/" + ModuleName + ".html>"
					+ ModuleName + "</a></font></TD></TR>");
			opw.close();
		} else {

			System.out.println("Inside Else Part of OverViewModuleReport");
			opw.println("<TR>");
			opw.println("<TD colspan=" + 6 + " align=" + "center" + "><font color=" + ModuleName_font_color
					+ "><a href=file://C:/workspace/Ravi/AutomationProjectDemo/TestReports/" + ModuleName + ".html>"
					+ ModuleName + "</a></font></TD></TR>");
			opw.close();
		}
	}

	public static void OverViewModuleReport_TestCases(PrintWriter opw, String TestCaseName) throws IOException {
		System.out.println("Inside OverViewModuleReport_TestCases");
		opw.println("<TR><TD align=" + "center" + "><font color=" + Content_font_Color + ">" + TestCaseName);
	}

	public static void OverviewstatusUpdating(PrintWriter opw, String MethodName, String TestCase_Description,
			String TestCase_Status, boolean test, Date executionTime) throws Exception {
		System.out.println("Inside OverviewstatusUpdating");

		if (ScreenShot_Cond) {

			System.out.println("Inside If Part of OverviewstatusUpdating");
			if (test) {
				opw.println("</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ TestCase_Description + "</font><TD align=" + "center" + "><font color=" + Content_font_Color
						+ ">" + TestCase_Status + "</font><TD bgcolor = #80ff00 align=" + "center" + "><font color="
						+ Content_font_Color + ">" + "Pass" + "</font><TD align=" + "center" + "><font color="
						+ Content_font_Color + ">" + dateFormat.format(executionTime) + "</font></TR>");

				opw.close();
			} else {
				opw.println("</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">"
						+ TestCase_Description + "</font><TD align=" + "center" + "><font color=" + Content_font_Color
						+ ">" + TestCase_Status + "</font><TD bgcolor = #ff0000 align=" + "center" + "><font color="
						+ Content_font_Color + ">" + "Fail" + "</font><TD align=" + "center" + "><font color="
						+ Content_font_Color + ">" + dateFormat.format(executionTime) + "</font></TR>");

				opw.close();
			}
		} else {

			System.out.println("Inside Else Part of OverviewstatusUpdating");

			if (!ScreenShotCheck(MethodName)) {
				if (test) {
					opw.println("</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">"
							+ TestCase_Description + "</font><TD align=" + "center" + "><font color="
							+ Content_font_Color + ">" + TestCase_Status + "</font><TD bgcolor = #80ff00 align="
							+ "center" + "><font color=" + Content_font_Color + ">" + "Pass" + "</font><TD align="
							+ "center" + "><font color=" + Content_font_Color + ">" + dateFormat.format(executionTime)
							+ "</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">" + ""
							+ "</font></TR>");

					opw.close();
				} else {
					opw.println("</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">"
							+ TestCase_Description + "</font><TD align=" + "center" + "><font color="
							+ Content_font_Color + ">" + TestCase_Status + "</font><TD bgcolor = #ff0000 align="
							+ "center" + "><font color=" + Content_font_Color + ">" + "Fail" + "</font><TD align="
							+ "center" + "><font color=" + Content_font_Color + ">" + dateFormat.format(executionTime)
							+ "</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">" + ""
							+ "</font></TR>");

					opw.close();
				}
			} else {
				if (test) {
					opw.println("</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">"
							+ TestCase_Description + "</font><TD align=" + "center" + "><font color="
							+ Content_font_Color + ">" + TestCase_Status + "</font><TD bgcolor = #80ff00 align="
							+ "center" + "><font color=" + Content_font_Color + ">" + "Pass" + "</font><TD align="
							+ "center" + "><font color=" + Content_font_Color + ">" + dateFormat.format(executionTime)
							+ "</font><TD align=" + "center" + "><font color=" + Content_font_Color
							+ "><a href=file://C:/workspace/Ravi/AutomationProjectDemo/Project_ScreenShots/"
							+ MethodName + ".png>" + ScreenShot + "</a></font></TR>");

					opw.close();
				} else {
					opw.println("</font><TD align=" + "center" + "><font color=" + Content_font_Color + ">"
							+ TestCase_Description + "</font><TD align=" + "center" + "><font color="
							+ Content_font_Color + ">" + TestCase_Status + "</font><TD bgcolor = #ff0000 align="
							+ "center" + "><font color=" + Content_font_Color + ">" + "Fail" + "</font><TD align="
							+ "center" + "><font color=" + Content_font_Color + ">" + dateFormat.format(executionTime)
							+ "</font><TD align=" + "center" + "><font color=" + Content_font_Color
							+ "><a href=file://C:/workspace/Ravi/AutomationProjectDemo/Project_ScreenShots/"
							+ MethodName + ".png>" + ScreenShot + "</a></font></TR>");

					opw.close();
				}
			}
		}
	}

	public static void OverviewstatusReport_TC(PrintWriter opw) throws Exception {
		System.out.println("Inside OverviewstatusReport_TC");
		opw.println("</TABLE>");
		opw.println("</TR>");

	}

	public static void OverviewstatusReportClose() throws Exception {
		opw.println("</TABLE>");
		opw.close();
	}

	public static boolean ScreenShotCheck(String MethodName) throws Exception {

		System.out.println("Inside ScreenShotCheck");
		String methodName = MethodName + ".png";
		boolean k = false;
		File file = new File("./Project_ScreenShots");
		String[] myFiles;
		if (file.isDirectory()) {
			myFiles = file.list();
			if (myFiles.length != 0) {
				for (int i = 0; i < myFiles.length; i++) {
					System.out.println("myFiles : " + myFiles[i]);
					System.out.println("methodName :" + methodName);
					if (methodName.equalsIgnoreCase(myFiles[i])) {
						return k = true;
					}
				}
			}
		}
		return k;
	}
}
