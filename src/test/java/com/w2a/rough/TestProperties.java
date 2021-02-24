package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	/*
	 * WebDriver - done Properties - done Logs - log4j jar, log4j.properties
	 * ExtentReports DB Excel Mail ReportNG, ExtentReports Jenkins
	 */

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Vivek Maddu\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		fis = new FileInputStream("C:\\Users\\Vivek Maddu\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		// driver.findElement(By.cssselector(OR.getProperty("cartBtn"))).click();
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlBtn"));
	}
}
