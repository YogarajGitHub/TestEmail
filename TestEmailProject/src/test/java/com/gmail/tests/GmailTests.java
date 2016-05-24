package com.gmail.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gmail.commonFunctions.EmailDataProvider;
import com.gmail.commonFunctions.PropLoader;
import com.gmail.pages.InboxPage;
import com.gmail.pages.LoginPage;

public class GmailTests {

	//Declaring class variables
	private WebDriver driver = null;
	
	@BeforeTest
	public void setUp(){	
		PropLoader.getInstance().loadProps();
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test (dataProviderClass = EmailDataProvider.class, dataProvider = "dataProviderTest")
	public void emailSearchTest(String username,String password){

		LoginPage.getInstance(driver).login(username, password);
		
		InboxPage.getInstance(driver).searchEmail(PropLoader.getInstance().getValue("input.emailSubject"), PropLoader.getInstance().getValue("input.emailContent"));
		
		InboxPage.getInstance(driver).logout();	
	}
	
	@AfterTest
	public void cleanUp(){	
		if(driver != null){
			driver.quit();
		}
	}
}
