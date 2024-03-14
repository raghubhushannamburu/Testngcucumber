package com.automation.implementaion;

import com.automation.pages.HomePage;
import com.automation.utils.Elements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static com.automation.base.Base.driver;




public class Implementation extends Elements{
	public static Logger log=Logger.getLogger(Implementation.class);


	WebDriverWait wait = new WebDriverWait(driver,20);

	HomePage homePo=new HomePage();



	public void IclickABTestinglink() {

		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a")));
			clickObject(homePo.button, "button");
			//Assert.assertEquals("A/B Test Variation 1",homePo.text.getText());
            System.out.print(homePo.text.getText());
			driver.navigate().back();
		}catch (Exception e) {
			log.error("Failed due to error"+e.getMessage());
		}
	}




      public void Iclickondropdownlink(){
		  try {
			  Thread.sleep(5000);
			  clickObject(homePo.dropdown,"dropdown");
			  Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
			  select.selectByIndex(1);

			  Assert.assertEquals("Option 1",select.getFirstSelectedOption().getText());
			  driver.navigate().back();
		  } catch (Exception e) {
			  log.error("Failed due to error"+e.getMessage());

		  }
	  }
	public void Iclickonframes() {
		try {

          clickObject(homePo.frames,"frames");
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			allLinks.get(0).getText().equals("Nested Frames");
			allLinks.get(1).getText().equals("iFrame");

		} catch (Exception e) {
			log.error("Failed due to error"+e.getMessage());

		}
	}


	

}
