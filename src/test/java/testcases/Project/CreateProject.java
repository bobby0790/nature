package testcases.Project;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import resources.BaseTest;

public class CreateProject extends BaseTest
{
	@Test(dataProvider="getData")
	public void createProject(String tdid, String username, String password, String JobTitle) throws Exception
	{
		test = extent.createTest("Post as Circle");
		test.pass("Start the Browser");
		initiateBrowser();
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
		sendkeys(TextJobTitle, JobTitle);
		wait(1);
	}
}
