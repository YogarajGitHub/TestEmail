package com.gmail.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gmail.commonFunctions.PropLoader;
import com.gmail.commonFunctions.SeleniumOperations;

public class InboxPage {
	
	//Declaring class variables
	private WebDriver driver = null;
	
	//Creating singleton object
	private static InboxPage objInboxPage = null;
	
	private InboxPage(WebDriver driver){
		this.driver = driver;
	}
	
	public static InboxPage getInstance(WebDriver driver){
		
		if(objInboxPage == null){
			objInboxPage = new InboxPage(driver);
		}
	
		return objInboxPage;
	}
	
	//search email with specified subject and contents
	public void searchEmail(String emailSubject, String emailContents){
		
		//Declaring variables
		List<WebElement> emailArray = null;
		WebElement tmpElement = null;
		String subjectActual = null;
		String contentsActual = null;
		
		//Wait for email to present
		tmpElement = SeleniumOperations.getInstance(driver).waitForElementByXpath(PropLoader.getInstance().getValue("gmail.inbox.email.table"));
		
		if(tmpElement != null){
			emailArray = driver.findElements(By.xpath("//*[@id=':3k']/tbody/tr"));
			
			for(int i=0; i < emailArray.size(); i++){
				
				subjectActual = driver.findElement(By.xpath("//*[@id=':3k']/tbody/tr["+(i+1)+"]/td[6]/div/div/div/span")).getText();
				contentsActual = driver.findElement(By.xpath("//*[@id=':3k']/tbody/tr["+(i+1)+"]/td[6]/div/div/div/span[2]")).getText();
				
				if(subjectActual.equalsIgnoreCase(emailSubject)){
					System.out.println("Email with Subject "+emailSubject+" Present");
					if(contentsActual.contains(emailContents)){
						System.out.println("Email also has expected Content "+emailContents);
					}else{
						System.out.println("Email contents did not have "+emailContents);
					}
					break;
				}
			}
		}else{
			System.out.println("Either inbox page not displayed or Email table did not loaded properly...");
		}
		
		
	}
	
	public void logout(){
		//Click on logout link
		SeleniumOperations.getInstance(driver).clickElement("gmail.inbox.logoutSpan");
		SeleniumOperations.getInstance(driver).clickElement("gmail.inbox.logout");
	}

}
