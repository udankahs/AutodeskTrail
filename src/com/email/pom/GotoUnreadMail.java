package com.email.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/

public class GotoUnreadMail {

	private WebDriver driver;
	public boolean message; 
	
	@FindBy(id = "fltrc")
	private WebElement Filter;

	@FindBy(xpath = "//*[@id=('_divUnread')]")
	private WebElement unread;
	
	@FindBy(id = "btnFltrApp")
	private WebElement Apply;
	
	@FindBy(id = "btn0")
	private WebElement OK;
	
	@FindBy(xpath = "//div[@id='divSubject' and contains(text(), 'Salesforce.com password confirmation')][1]")
	private WebElement FirstMail;

	@FindBy(id = "divMR")
	private WebElement MarkAsRead;

	@FindBy(xpath ="//body//a[1]")
	private WebElement pswRestLink;

	@FindBy(id = "p5")
	private WebElement enterPWD;

	@FindBy(id = "p6")
	private WebElement reEnterPWD;

	@FindBy(xpath = "html/body/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/table/tbody/tr/td[1]/button")
	private WebElement Menu;

	@FindBy(xpath = "//span[text()='sign out']")
	private WebElement Logout;

	@FindBy(xpath = "//input[@type=('submit') and @title=('Save')]")
	private WebElement Save;

	@FindBy(xpath = "//a")
	private WebElement Continue;

	public GotoUnreadMail(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean gotoUnreadMail(String pwd) throws InterruptedException 
	{
		Filter.click();
		unread.click();
		Apply.click();
		
		try{
		OK.click();
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(FirstMail));
		FirstMail.click();
		driver.switchTo().frame("ifBdy");
		String url = pswRestLink.getText();
		System.out.println(url);
		
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		action.moveToElement(FirstMail).contextClick().build().perform();

		MarkAsRead.click();
		Thread.sleep(5000);
		Logout.click();

		driver.get(url);

		String title = driver.getTitle();
		System.out.println(title);

		if (title.equals("salesforce.com - Customer Secure Login Page")) 
		{
			message = false;
		} 
		else if (title.equals("Scheduled Improvements @ salesforce.com")) 
		{
			Continue.click();
			enterPWD.sendKeys(pwd);
			reEnterPWD.sendKeys(pwd);
			Save.click();
			Thread.sleep(6000);
			message = true;
		} 
		else if (title.contains("Force.com Home Page ~ salesforce.com - Developer Edition")) 
		{
			enterPWD.sendKeys(pwd);
			reEnterPWD.sendKeys(pwd);
			Save.click();
			Thread.sleep(6000);
			message = true;
		}
		return message;
	}
}
