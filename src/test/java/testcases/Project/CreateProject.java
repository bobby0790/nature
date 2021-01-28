package testcases.Project;

import org.testng.annotations.Test;

import resources.BaseTest;

public class CreateProject extends BaseTest
{
	@Test(dataProvider="getData")
	public void createProject(String tdid, String username, String password) throws Exception
	{
		test = extent.createTest("Post as Circle");
		test.pass("Start the Browser");
		initiateBrowser();
		clickElement(LoginBtn);
		wait(1);
		sendKeys(TextUserName,username);
		wait(1);
		sendkeys(TextPassword,password);
		wait(1);
		clickElement(ClickLoginBtn);
		wait(1);
		clickElement(ClickProject);
		wait(1);
		clickElement(clickAddNewProject);
		wait(1);
		clickElement(clickAddJob);
		wait(1);
		
	}

}
