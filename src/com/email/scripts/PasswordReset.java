package com.email.scripts;

import org.testng.annotations.Test;

import com.email.pom.EmailLoginPage;
import com.email.pom.GotoUnreadMail;
import com.email.pom.iREPLoginPage;
import com.email.pom.iREPPasswordResetUser;
import com.lib.ExcelLib;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/

public class PasswordReset extends iREPSuperTestNG {
	@Test
	public void testPasswordReset() throws Exception {
		iREPLoginPage loginPage = new iREPLoginPage(driver);
		iREPPasswordResetUser passwordReset = new iREPPasswordResetUser(driver);

		// String EmailID = LoginDialog.CTSUserEmail;
		// String eMailUname = LoginDialog.CTSUsername;
		// String eMailpassword = LoginDialog.CTSPassword;

		String EmailID = "udanka.hs@cognizant.com";
		String eMailUname = "266241";
		String eMailpassword = "cr0ssword@";

		String xlPath = "D:/SPURP/SPURP Test Data.xls";
		String sheetName = "Password Reset";

		int rowCount = ExcelLib.getRowCount(xlPath, sheetName);

		for (int i = 1; i <= rowCount; i++) {
			String iREPUname = ExcelLib.getCellValue(xlPath, sheetName, i, 0);
			String iREPpassword = ExcelLib
					.getCellValue(xlPath, sheetName, i, 1);

			String PrfoUname = ExcelLib.getCellValue(xlPath, sheetName, i, 2);
			String newPWD = ExcelLib.getCellValue(xlPath, sheetName, i, 3);

			loginPage.login(iREPUname, iREPpassword);
			passwordReset.reset(PrfoUname, EmailID);

			EmailLoginPage emailLogin = new EmailLoginPage(driver);
			emailLogin.login(eMailUname, eMailpassword);

			GotoUnreadMail unRead = new GotoUnreadMail(driver);
			unRead.gotoUnreadMail(newPWD);
		}
	}
}
// driver.quit();
