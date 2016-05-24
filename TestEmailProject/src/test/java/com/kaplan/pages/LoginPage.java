package com.kaplan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kaplan.commonFunctions.PropLoader;
import com.kaplan.commonFunctions.SeleniumOperations;

public class LoginPage {

	private WebDriver driver=null;
	
	//Code for creating singleton object
	private static LoginPage objLoginPage = null;
	
	private LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public static LoginPage getInstance(WebDriver driver){
		if(objLoginPage == null){
			objLoginPage = new LoginPage(driver);
		}
		return objLoginPage;
	}
	
	//Function to launch URL
	public void launchURL(){
		if(driver!=null){
			driver.get(PropLoader.getInstance().getValue("url.gmail"));
		}else{
			System.out.println("Driver is not yet initialized");
		}
	}
	
	//Function for login operation
	public void login(String username,String password){

		//Call for launch url
		launchURL();
		
		//Type username
		SeleniumOperations.getInstance(driver).typeElement("gmail.login.username",username);
		//Click on next button
		SeleniumOperations.getInstance(driver).clickElement("gmail.login.next");
		//Type password
		SeleniumOperations.getInstance(driver).typeElement("gmail.login.password",password);
		//Click on SignIn
		SeleniumOperations.getInstance(driver).clickElement("gmail.login.signIn");
		
	}
	
}
