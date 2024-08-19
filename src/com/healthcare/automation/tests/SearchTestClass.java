package com.healthcare.automation.tests;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.healthcare.automation.listeners.MethodInterceptor;
import com.healthcare.automation.main.MainRunner;

@Listeners(MethodInterceptor.class)
public class SearchTestClass extends BaseTestClass {
	private static final Logger LOGGER=LoggerFactory.getLogger(SearchTestClass.class);
	
	@Test
	 public void testLogin() {
		LOGGER.info("SearchTestClass - testLogin");
		 try {
		 test = extent.createTest("testLogin"); 
		 driver.get(MainRunner.getDefaultAutomationProp().getProperty("url").toString()); 
	     test.pass("Logged in successfully.");
		 }catch (Exception e) {
			
			LOGGER.error("Error while logging in:"+ExceptionUtils.getStackTrace(e));
		}
		 
	    }
	
	
	 @Test
	 public void testSearch() {
		 LOGGER.info("SearchTestClass - testSearch");
		 try {
		 test = extent.createTest("testSearch");
		driver=null;
		 driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Test NG");	
		 driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);		 
	     test.pass("searched  successfully.");
		 }catch (Exception e) {
			 LOGGER.error("Error while Searching:"+ExceptionUtils.getStackTrace(e));
		}
		 
	    }

}
