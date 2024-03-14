package com.automation.config;

import com.automation.utils.PathHelper;
import org.apache.log4j.Logger;

import java.util.Properties;

public class PropertyFileReader {
	
	public static Logger log=Logger.getLogger(PropertyFileReader.class);
	Properties prop=new Properties();

	
	public PropertyFileReader(){
		try{   
			prop.load(PathHelper.getInputStreamresourcePath("/src/main/resources/ConfigFile/config.properties"));

		}
		catch(Exception e){
			log.info("The Config File is not found and error message is: "+e.getMessage());
		}
	}
	
	public String getEnviroment(){
		return prop.getProperty("Environment");
	}
	
	public String getBrowser(){
		return prop.getProperty("Browser");
	}
	
	public String getUserName(){
		return prop.getProperty("UserName");
	}
	
	public String getPassword(){
		return prop.getProperty("Password");
	}
	

	
	public String geApplicationUrl(){
		return prop.getProperty("URL");
	}
	public String getUrlUserName(){
		return prop.getProperty("urlUserName");
	}

	public String getUrlPassword(){
		return prop.getProperty("urlPassWord");
	}
	

	
public String getReportConfigPath(){
	String reportConfigPath=PathHelper.getResourcePath("/src/main/resources/ConfigFile/extent-config.xml");
	if(reportConfigPath!=null) return reportConfigPath;
	else throw new RuntimeException("Report Config path not specified");
}
}
