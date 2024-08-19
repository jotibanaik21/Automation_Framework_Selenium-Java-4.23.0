package com.healthcare.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.*;


public class WebDriverManager {
	static WebDriver driver;

	public WebDriverManager( WebDriver driver) {
		WebDriverManager.driver=driver;
	}

	public static  WebDriver getDriver() {
		return driver;

	}

	public void setUpDriver(String browser) {

		switch (browser) {

		case "chrome": 

					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"chromedriver.exe");
					ChromeOptions chromeOptions=new ChromeOptions();
					chromeOptions.addArguments("--no-sandbox");
					chromeOptions.addArguments("--disable-pop-blocking");
					chromeOptions.addArguments("--disable-infobars");
					chromeOptions.addArguments("--disable-dev-shm-usage");
					String path="C:\\Program Files (x86)\\Google\\Chrome\\Application";
					File applicationPath=new File(path);
					if (applicationPath.exists()) {
						path="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		
					}else {
						path="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		
					}
					chromeOptions.setBinary(path);		
					driver= new ChromeDriver(chromeOptions);
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.manage().window().maximize();
					break;	

		case "chrome-headless":  
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"chromedriver.exe");
					ChromeOptions chromeOption1=new ChromeOptions();
					chromeOption1.addArguments("--headless");
					chromeOption1.addArguments("--disable-gpu");
					chromeOption1.addArguments("--window-size=1400,800");
		
					chromeOption1.addArguments("--no-sandbox");
					chromeOption1.addArguments("--disable-pop-blocking");
					chromeOption1.addArguments("--disable-infobars");
					chromeOption1.addArguments("--disable-dev-shm-usage");
					String path1="C:\\Program Files (x86)\\Google\\Chrome\\Application";
					File applicationPath1=new File(path1);
					if (applicationPath1.exists()) {
						path1="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		
					}else {
						path1="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		
					}
					chromeOption1.setBinary(path1);		
					driver= new ChromeDriver(chromeOption1);
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					driver.manage().window().maximize();
					break;
			
		case "edge":  
				    System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
					driver = new EdgeDriver();
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;
		
		case "edge-headless": 
					System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
					EdgeOptions edgeOptions=new EdgeOptions();
					edgeOptions.addArguments("headless");
					driver = new EdgeDriver(edgeOptions);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + browser);

		}
	}


}
