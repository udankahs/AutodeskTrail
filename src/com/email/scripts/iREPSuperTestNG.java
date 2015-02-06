package com.email.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/

public class iREPSuperTestNG 
{
	public WebDriver driver;
	
	
	@BeforeMethod
	public void preCondition()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
	}
//	@AfterMethod
//	public void postCondition()
//	{
//	   driver.quit();	
//	}
}
