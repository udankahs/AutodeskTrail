package com.email.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iREPPasswordResetUser {
	private WebDriver driver;

	boolean status;

	@FindBy(id = "userNavButton")
	private WebElement userNavLabel;

	@FindBy(id = "phSearchInput")
	private WebElement SearchBox;

	@FindBy(id = "phSearchButton")
	private WebElement SearchButton;

	@FindBy(xpath = "//div[@id='User']//div[@class='displayName']//a")
	private WebElement User;

	@FindBy(id = "moderatorMutton")
	private WebElement DownArrow;

	@FindBy(xpath = "//a[contains (text(), 'Edit Profile')]")
	private WebElement Edit;

	@FindBy(xpath = "//a[contains (text(), 'Setup')]")
	private WebElement Setup;

	@FindBy(id = "Users_font")
	private WebElement ManageUsers;

	@FindBy(id = "ManageUsers_font")
	private WebElement Users;

	@FindBy(id = "Email")
	private WebElement Email;

	@FindBy(id = "new_password")
	private WebElement PasswordResetCheckbox;

	@FindBy(xpath = "//input[@value='Email me a verification code']")
	private WebElement EmailMeButton;

	@FindBy(id = "userNavLabel")
	private WebElement Menu;

	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	private WebElement Logout;

	@FindBy(xpath = "//*[@id='topButtonRow']/input[@type=('submit') and @title=('Save')]")
	private WebElement Save;

	public iREPPasswordResetUser(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean reset(String UserName, String email)
			throws InterruptedException {
		if (driver.getTitle().contains("salesforce.com - Enterprise Edition")) {
			SearchBox.click();
			SearchBox.sendKeys(UserName);
			SearchButton.click();
			Thread.sleep(5000);
			User.click();
			DownArrow.click();
			Edit.click();
			Email.clear();
			Email.sendKeys(email);
			PasswordResetCheckbox.click();
//			Save.click();
//			Menu.click();
//			Logout.click();
//			Thread.sleep(5000);

			status = true;

		} else if (driver.getTitle().equals(
				"salesforce.com - Activation Required")) {
			try {
				EmailMeButton.click();
				Thread.sleep(40000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			SearchBox.click();
			SearchBox.sendKeys(UserName);
			SearchButton.click();
			Thread.sleep(8000);
			User.click();
			DownArrow.click();
			Edit.click();
			Email.clear();
			Email.sendKeys(email);
			PasswordResetCheckbox.click();
//			Save.click();
//			Menu.click();
//			Logout.click();
//			Thread.sleep(5000);

			status = true;

		} else {
			status = false;
		}
		Thread.sleep(6000);
		return status;
	}

}
