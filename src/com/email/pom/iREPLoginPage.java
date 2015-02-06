package com.email.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/

public class iREPLoginPage {
	private WebDriver driver;

	@FindBy(id = "username")
	private WebElement unTextBox;

	@FindBy(id = "password")
	private WebElement pwTextBox;

	@FindBy(id = "Login")
	private WebElement loginButton;

	public iREPLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void login(String un, String pw) throws InterruptedException {
		driver.get("https://login.salesforce.com");
		unTextBox.sendKeys(un);
		pwTextBox.sendKeys(pw);
		loginButton.click();
	}
}
