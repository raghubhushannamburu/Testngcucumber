package com.automation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automation.base.Base.driver;

public class HomePage extends BasePage {
	public static Logger log=Logger.getLogger(HomePage.class);


	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy(xpath="//li/a")
	public WebElement button;
	


	@FindBy(xpath = "//div/h3")
	public  WebElement text;




	@FindBy(xpath = "//ul/li[11]/a")
	public WebElement dropdown;

	@FindBy(xpath = "//*[@id=\"dropdown\"]")
	public WebElement dropdownlist;

	@FindBy(xpath = "//ul")
	public WebElement frameslist;

	@FindBy(xpath = "//ul/li[22]/a")
	public WebElement  frames;



}
