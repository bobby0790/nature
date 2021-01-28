package testcases.login;

import org.testng.annotations.Test;

import resources.BaseTest;

public class Login extends BaseTest
{
	@Test(dataProvider="getData")
	public void loggin(String tdid, String username, String password) throws Exception
	{
		test = extent.createTest("Login");
		test.pass("Start the Browser");
		initiateBrowser();
		clickElement(LoginBtn);
		wait(3);
		sendKeys(TextUserName,username);
		wait(3);
		sendkeys(TextPassword,password);
		wait(3);
		clickElement(ClickLoginBtn);
		wait(5);
		
	}

}
