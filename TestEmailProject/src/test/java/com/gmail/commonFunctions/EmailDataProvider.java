package com.gmail.commonFunctions;

import org.testng.annotations.DataProvider;

public class EmailDataProvider {

	@DataProvider
	public static Object[][] dataProviderTest(){
		String usernames[] = PropLoader.getInstance().getValue("gmail.username").split(";;");
		String passwords[] = PropLoader.getInstance().getValue("gmail.password").split(";;");
		Object[][] objArr = new Object[usernames.length][passwords.length];
		
		for(int i=0; i< usernames.length; i++){
			objArr[i][0] = usernames[i];
			objArr[i][1] = passwords[i];
		}
		//return new Object[][] {{"kaplan.interview.test1@gmail.com","Welcome@12"},{"kaplan.interview.test2@gmail.com","Welcome@12"}};
		return objArr;
	}
}
