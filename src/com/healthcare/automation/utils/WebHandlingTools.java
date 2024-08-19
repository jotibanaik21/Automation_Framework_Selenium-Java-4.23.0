package com.healthcare.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebHandlingTools {
	private WebDriver driver;

    public WebHandlingTools(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }
}
