package com.automation.utils;

import org.openqa.selenium.WebElement;

public class Elements {
	
	public void clickObject(WebElement element, String elementName){
		element.click();
		
	}
	
	public void SendInput(WebElement element, String data, String elementName){
		element.sendKeys(data);
		
	}
	
}
