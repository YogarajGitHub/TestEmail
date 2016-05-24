package com.kaplan.commonFunctions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropLoader {

	//Declaring class variables
	private Properties prop = null; 
	private InputStream input = null;
	
	//Creating Singleton object
	private static PropLoader objPropLoader = null;
	
	private PropLoader(){
		
	}
	
	public static PropLoader getInstance(){
		if(objPropLoader == null){
			objPropLoader = new PropLoader();
		}
		return objPropLoader;
	}
	
	public void loadProps(){
		try {
			prop = new Properties();
			input = new FileInputStream("src/test/resources/properties/cofig.properties");
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Exception in loading property files \n"+e.getMessage());
		}
	}
	
	//Read value from properties
	public String getValue(String input){
		if(prop != null){
			if(prop.getProperty(input).contains("::")){
				return prop.getProperty(input).split("::")[0].toString();
			}else{
				return prop.getProperty(input);
			}
		}else{
			System.out.println("Property is not yet initialized...");
			return null;
		}
	}
	
	//Read type from properties
	public String getType(String input){
		if(prop !=null){
			return prop.getProperty(input).split("::")[1].toString();
		}else{
			System.out.println("Property is not yet intialized...");
			return null;
		}
	}
}
