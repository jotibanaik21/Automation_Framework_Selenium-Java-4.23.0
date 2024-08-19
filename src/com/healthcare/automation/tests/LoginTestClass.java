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
public class LoginTestClass extends BaseTestClass{
	private static final Logger LOGGER=LoggerFactory.getLogger(LoginTestClass.class);
	 @Test
	 public void testLogin() {
		 LOGGER.info("LoginTestClass - testLogin");
		 try {
		 test = extent.createTest("testLogin"); 
		 driver.get(MainRunner.getDefaultAutomationProp().getProperty("url").toString()); 
	     test.pass("Logged in successfully.");
		 }catch (Exception e) {
			
			LOGGER.error("Error while logging in:"+ExceptionUtils.getStackTrace(e));
		}
		 
	    }

	
	 
	
}
