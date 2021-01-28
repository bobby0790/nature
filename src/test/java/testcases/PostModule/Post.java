package testcases.PostModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseTest;

public class Post extends BaseTest
{
	@Test(dataProvider="getData")
	public void post(String tdid, String username, String password, String PostDescription, String PostHashTags) throws Exception
	{
		test = extent.createTest("Post Creation");
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
		wait(1);
		sendkeys(TextPostDescription,PostDescription);
		wait(1);
		WebElement dri=driver.findElement(By.id("colon"));
		dri.sendKeys(PostHashTags);
		dri.sendKeys(Keys.ENTER);
		//sendkeys(TextPostHashTags, PostHashTags);
		wait(1);
		clickElement(ClickPostButton);
		wait(2);
	}
}
