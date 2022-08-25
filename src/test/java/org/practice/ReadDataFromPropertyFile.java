package org.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException  {
		
		//Use file Input Stream to load the property file
		FileInputStream fis = new FileInputStream("./data/commonData.properties");
		
		//Create object of properties and load the file
		Properties prop = new Properties();
		prop.load(fis);
		
		//Provide the key to read the value
		String URL = prop.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = prop.getProperty("username");
		System.out.println(USERNAME);
		
		
	} 

}
