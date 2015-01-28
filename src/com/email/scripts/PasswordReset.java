package com.email.scripts;

import org.testng.annotations.Test;

import com.email.pom.EmailLoginPage;
import com.email.pom.GotoUnreadMail;
import com.email.pom.iREPLoginPage;
import com.email.pom.iREPPasswordResetProfile;
import com.email.pom.iREPPasswordResetUser;
import com.lib.ExcelLib;

public class PasswordReset extends iREPSuperTestNG 
{
	@Test
	public void testPasswordReset() throws Exception 
	{
		iREPLoginPage loginPage = new iREPLoginPage(driver);
		iREPPasswordResetUser passwordReset = new iREPPasswordResetUser(driver);

		//String iREPUname = DetailFieldValues.adminUname;
		//String iREPpassword = DetailFieldValues.adminPaswd;
		String EmailID = LoginDialog.CTSUserEmail;
		String eMailUname = LoginDialog.CTSUsername;
		String eMailpassword = LoginDialog.CTSPassword;
		//String newPWD = DetailFieldValues.AllUserPWD;
		
		String xlPath = "D:/SPURP/SPURP Test Data.xls";
		String sheetName = "Password Reset";
		
		System.out.println(EmailID);
		System.out.println(eMailUname);
		System.out.println(eMailpassword);

		int rowCount = ExcelLib.getRowCount(xlPath, sheetName);

		for (int i = 1; i <= rowCount; i++) 
		{
			String iREPUname = ExcelLib.getCellValue(xlPath, sheetName ,i, 0);
			String iREPpassword = ExcelLib.getCellValue(xlPath, sheetName, i, 1);

			String PrfoUname = ExcelLib.getCellValue(xlPath, sheetName, i, 2);
			String newPWD = ExcelLib.getCellValue(xlPath, sheetName, i,3);

			loginPage.login(iREPUname, iREPpassword);
			passwordReset.reset(PrfoUname, eMailUname);

			EmailLoginPage emailLogin = new EmailLoginPage(driver);
			emailLogin.login(eMailUname, eMailpassword);

			GotoUnreadMail unRead = new GotoUnreadMail(driver);
			unRead.gotoUnreadMail(newPWD, EmailID);

			ExcelLib.writeExcel(xlPath, sheetName, i, 4, "Pass");
		}
		driver.quit();
	}
}
