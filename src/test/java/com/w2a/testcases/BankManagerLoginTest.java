package com.w2a.testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;


public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager () {
		
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		
		Assert.assertFalse(isElementPresent(By.cssSelector(OR.getProperty("addBtn"))),"Login Not successfull");
		
		
		log.debug("Login Successfully Executed");
		Reporter.log("Login Successfully Executed");
		Reporter.log("<a \"target=_blank\" href=\"C:\\Users\\Vivek Maddu\\Pictures\\Screenshots\\error.png\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a \"target=_blank\" href=\"C:\\Users\\Vivek Maddu\\Pictures\\Screenshots\\error.png\"><img src=\"C:\\Users\\Vivek Maddu\\Pictures\\Screenshots\\error.png\" height=200 width=200></img></a>");
		
	}
	

}
