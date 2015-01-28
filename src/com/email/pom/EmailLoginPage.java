package com.email.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailLoginPage
{
	private WebDriver driver;
	
	@FindBy(id="username")
	private WebElement unTextBox;
	
	@FindBy(id="password")
	private WebElement pwTextBox;
	
	@FindBy(xpath="//input [@class='btn' and  @value='Sign in']")
	private WebElement loginButton;
	
	public EmailLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void login(String un,String pw)
	{
		driver.get("https://mail.cognizant.com/");
		unTextBox.sendKeys(un);
		pwTextBox.sendKeys(pw);
		loginButton.click();
	}
	
}
