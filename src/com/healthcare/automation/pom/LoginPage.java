package com.healthcare.automation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {


	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="username")
	private WebElement userNameTextbox;
	
	@FindBy(how=How.ID,using="password")
	private WebElement passwordTextbox;
	
	@FindBy(how=How.ID,using="login")
	private WebElement loginButton;
	
	
	public WebElement getUserNameTextbox() {
		return userNameTextbox;
	}

	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	
	
	
	
}
