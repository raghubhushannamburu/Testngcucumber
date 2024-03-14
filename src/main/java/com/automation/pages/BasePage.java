package com.automation.pages;

import com.automation.base.Base;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public BasePage() {
		PageFactory.initElements(Base.driver, this);
	}

}
