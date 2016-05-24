package com.gmail.commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumOperations {

	private WebDriver driver = null;
	//Code for creating singleton object
	private static SeleniumOperations objSeleOperations = null;
	
	private SeleniumOperations(WebDriver driver){
		this.driver = driver;
	}
	
	public static SeleniumOperations getInstance(WebDriver driver){
		if(objSeleOperations == null){
			objSeleOperations = new SeleniumOperations(driver);
		}
		return objSeleOperations;
	}
	
	//Function to wait until element with id present
	public WebElement waitForElementById(String id){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(
		        ExpectedConditions.elementToBeClickable(By.id(id)));
		return element;
	}
	
	//Function to wait until element with id present
	public WebElement waitForElementByXpath(String xpath){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return element;
	}
	
	//Function to wait until element with id present
	public WebElement waitForElementByLinkText(String linkText){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(
		        ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
		return element;
	}
	
	//Function to perform click operation on WebElement
	public void clickElement(String elementProperty){
		
		//Declaring variables
		WebElement tmpElement=null;
		String locType = PropLoader.getInstance().getType(elementProperty);
		String locValue = PropLoader.getInstance().getValue(elementProperty);
		
		switch (locType.toUpperCase()) {
		case "ID":
			tmpElement = waitForElementById(locValue);
			break;
		case "LINKTEXT":
			tmpElement = waitForElementByLinkText(locValue);
			break;
		case "XPATH":
			tmpElement = waitForElementByXpath(locValue);
			break;
		}
		
		tmpElement.click();
		
	}
	
	//Function to perform click operation on WebElement
	public String getTextElement(String elementProperty){
		
		//Declaring variables
		WebElement tmpElement=null;
		String locType = PropLoader.getInstance().getType(elementProperty);
		String locValue = PropLoader.getInstance().getValue(elementProperty);
		
		switch (locType.toUpperCase()) {
		case "ID":
			tmpElement = waitForElementById(locValue);
			break;
		case "LINKTEXT":
			tmpElement = waitForElementByLinkText(locValue);
			break;
		case "XPATH":
			tmpElement = waitForElementByXpath(locValue);
			break;
		}
		
		return tmpElement.getText();
		
	}
	
	//Function to perform type operation on WebElement
	public void typeElement(String elementProperty,String value){
		
		//Declaring variables
		WebElement tmpElement=null;
		String locType = PropLoader.getInstance().getType(elementProperty);
		String locValue = PropLoader.getInstance().getValue(elementProperty);
		
		switch (locType.toUpperCase()) {
		case "ID":
			tmpElement = waitForElementById(locValue);
			break;
		}
		
		tmpElement.sendKeys(value);
		
	}
}
