package testcases.PostModule;

import org.testng.annotations.Test;

import resources.BaseTest;

public class PostByImages extends BaseTest
{
	@Test(dataProvider="getData")
	public void postbyimages(String tdid, String username, String password) throws Exception
	{
		test = extent.createTest("Post an Images");
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
		clickElement(ClickPostImageBtn);
		robotMethod("D:\\Downloads\\Causes\\Bird Conservation.png");
		wait(5);
		clickElement(ClickPostImagePreviewClose);
		wait(2);
		clickElement(ClickPostImageBtn);
		robotMethod("D:\\Downloads\\Causes\\Climate Change.png");
		wait(2);
		clickElement(ClickPostImagePreviewClose);
		wait(1);
		clickElement(ClickPostImageBtn);
		robotMethod("D:\\Downloads\\Causes\\Coral Conservation.png");
		wait(2);
		clickElement(ClickPostImagePreviewClose);
		wait(1);
		clickElement(ClickPostButton);
		wait(2);
	}

}
