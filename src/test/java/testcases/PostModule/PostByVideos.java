package testcases.PostModule;

import org.testng.annotations.Test;

import resources.BaseTest;

public class PostByVideos extends BaseTest
{
	@Test(dataProvider="getData")
	public void postbyvideos(String tdid, String username, String password) throws Exception
	{
		test = extent.createTest("Post a Video");
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
		clickElement(ClickPost);
		wait(2);
		
	}

}
