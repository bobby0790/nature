package testcases.Forum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseTest;

public class ForumTitle extends BaseTest
{
	@Test(dataProvider="getData")
	public void forum(String tdid, String username, String password, String ForumTitle, String Description, String HashTags1, String HashTags2, String HashTags3, String HashTags4, String HashTags5, String HashTags6, String ForumTitle1, String Description1, String HashTags7, String HashTags8, String HashTags9, String HashTags10) throws Exception
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
		wait(2);
		clickElement(ClickForum);
		wait(3);
		clickElement(ClickAddForum);
		wait(2);
		sendkeys(TextForumTitle,ForumTitle);
		wait(3);
		sendkeys(TextForumDescription,Description);
		wait(3);
		String []hashtags=new String[]{HashTags1,HashTags2,HashTags3,HashTags4,HashTags5,HashTags6};
		for(int j=0;j<6;j++)
		{
			if(hashtags[j]!="")
			{
				WebElement dri=driver.findElement(By.xpath("//input[@class='ReactTags__tagInputField']"));
				dri.sendKeys(hashtags[j]);
				dri.sendKeys(Keys.ENTER);
			}
		}
		/*sendkeys(TextForumHashTags, "Test");
		wait(3);
		Actions TextForumHashTags=new Actions(driver);
		TextForumHashTags.sendKeys(Keys.ENTER);
		wait(3);*/
		clickElement(ClickForumPublish);
		wait(1);
		if(isDisplayed("//span[text()='Please enter the title']"))
			//if(driver.findElement(By.xpath("//span[text()='Please enter the title']")).isDisplayed())
			{
				/*String TitleErrorMessage=driver.findElement(By.xpath("//span[text()='Please enter the title']")).getText();
				System.out.println(TitleErrorMessage);
				wait(2);*/
				sendkeys(TextForumTitle,ForumTitle1);
				wait(2);
				clickElement(ClickForumPublish);
				wait(2);
			}
	}

	public boolean isDisplayed(String xpath)
	{
		try
		{
			return driver.findElement(By.xpath(xpath)).isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}	
}
