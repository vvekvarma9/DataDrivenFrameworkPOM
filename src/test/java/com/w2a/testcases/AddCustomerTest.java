package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass=TestUtil.class, dataProvider = "dp")
	public void addCustomer(Hashtable<String,String> data ) {

		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(data.get("firstName"));
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(data.get("lastName"));
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(data.get("postCode"));
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));	
		alert.accept();
		

	}

	
}