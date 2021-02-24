package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase {
	
	public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		screenshotName = "error.png";
		
		FileUtils.copyFile(scrFile, new File(System.getProperty("user .dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		
	}
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		String name = m.getName();
		int rows = excel.getRowCount(name);
		int cols = excel.getColCount();

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rownum = 2; rownum <= rows; rownum++) {
			table = new Hashtable<String, String>();

			for (int colnum = 0; colnum < cols; colnum++) {
				try {
					table.put(excel.getCellData(0, colnum), excel.getCellData(rownum - 1, colnum));
					data[rownum - 2][0] = table;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		log.debug("sucessfully read excel sheet");
		return data;
	} 

	public static String testcase;
	public static String runMode;

	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "TestSuit";
		int row = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= row; rNum++) {

			try {
				testcase = excel.getCellData(rNum, 0);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (testcase.equalsIgnoreCase(testName)) {

				try {
					runMode = excel.getCellData(rNum, 1);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (runMode.equalsIgnoreCase("y")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}


}
