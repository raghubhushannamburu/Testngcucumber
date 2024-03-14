package com.automation.base;


import com.automation.config.PropertyFileReader;
import com.automation.utils.PathHelper;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.mail.internet.AddressException;
import java.awt.*;
import java.io.File;


public class Base {
	public static Logger log = Logger.getLogger(Base.class);

	public static PropertyFileReader reader = new PropertyFileReader();
	public static WebDriver driver;


	@Before
	public void suiteSetUp(Scenario scenario) {
		PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigFile/log4j.properties"));
		log.info("Scenario Started: " + scenario.getName());
		startBrowser();
		maximizeWindow();
	}

	@SuppressWarnings("deprecation")
	public static void startBrowser() {

		try {
			switch (reader.getBrowser().toUpperCase()) {

				case "CHROME":
					System.setProperty("webdriver.chrome.driver", PathHelper.getBasePath() + "\\src\\main\\resources\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					break;

				case "EDGE":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				case "IE":
				case "INTERNET EXPLORER":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;

				case "FIREFOX":
					//System.setProperty("webdriver.gecko.driver", PathHelper.getBasePath()+"\\src\\main\\resources\\drivers\\geckodriver.exe");
					WebDriverManager.firefoxdriver().setup();
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("marionette", false);
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


					break;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}


	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}


	public static Actions getActionClassReference() {
		Actions action = new Actions(driver);
		return action;
	}

	public static JavascriptExecutor getJavaScriptExecutor() {
	JavascriptExecutor obj = (JavascriptExecutor) driver;
	 return obj;
	}

	@After
	public void closeBrowser(Scenario scenario) throws AddressException{
		if(scenario.isFailed()){
			String screenshotName=scenario.getName().replaceAll(" ", "-");
			try{
				File SourcePath=((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE);
				File directory=new File(PathHelper.getResourcePath("/tartget/cucumber-reports/screenshots"));
				if(!directory.exists())
					directory.mkdir();
				File destinationPath=new File(PathHelper.getResourcePath("/target/cucumber-reports/screenshots/"+ screenshotName +".png"));
				Files.copy(SourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			}
			catch(Exception e){
				log.info(e.getMessage());
				
			}
			
		}
		

		driver.quit();
		log.info("Scenario Completed: "+scenario.getName());
		log.info("Scenario Status is: "+scenario.getStatus());
		
		
	}
	


	public static void writeExtentReport(){
		Reporter.loadXMLConfig(new File(reader.getReportConfigPath()));
		Reporter.setSystemInfo("User Name", "test");
		Reporter.setSystemInfo("Browser", reader.getBrowser().toUpperCase());
		Reporter.setSystemInfo("Time Zone", "CST");
		Reporter.setSystemInfo("Machine", "windows 10 with 64 Bit");
		Reporter.setSystemInfo("Selenium", "3.11.0");
		Reporter.setSystemInfo("Java Version", "1.8");
		
	}
	
	public static void navigatetoautomationanywhere() throws InterruptedException, AWTException {

        Base.driver.get(Base.reader.geApplicationUrl());



	}

	
	
}
