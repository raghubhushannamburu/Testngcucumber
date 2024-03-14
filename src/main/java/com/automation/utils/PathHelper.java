package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PathHelper {
	
	public static String getBasePath(){
		return System.getProperty("user.dir");
	}
	
	public static String getResourcePath(String path){
		return getBasePath()+path;
	}

	public static FileInputStream getInputStreamresourcePath(String path)  throws FileNotFoundException{
		return new FileInputStream(getResourcePath(path));
	}
}
