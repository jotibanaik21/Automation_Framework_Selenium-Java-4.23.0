package com.healthcare.automation.tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.healthcare.automation.utils.WebDriverManager;


public class BaseTestClass {
	
	protected  WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected WebDriverManager webDriverManager;
    
    @BeforeClass
    public void setUp() {  
    	try {
    	//Setup Driver
    	webDriverManager=new WebDriverManager(driver);
    	webDriverManager.setUpDriver("chrome");
        driver = WebDriverManager.getDriver();
        driver.manage().window().maximize();
        
        //set up extent report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"extentReports.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Report");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }
    
    @AfterClass
    public void tearDown() {
    	
        if (driver != null) {
            driver.quit();
        }
        if (extent != null) {
            extent.flush();
        }
    }

	
}
