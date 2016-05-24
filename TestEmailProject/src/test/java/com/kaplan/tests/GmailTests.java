package com.kaplan.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kaplan.commonFunctions.PropLoader;
import com.kaplan.pages.LoginPage;

public class GmailTests {

	//Declaring class variables
	private WebDriver driver = null;
	
	@BeforeMethod
	public void setUp(){
		PropLoader.getInstance().loadProps();
		driver = new ChromeDriver();
	}
	
	@Test
	public void emailSearchTest(){

		LoginPage.getInstance(driver).login(PropLoader.getInstance().getValue("gmail.username"), PropLoader.getInstance().getValue("gmail.password"));
	}
}
