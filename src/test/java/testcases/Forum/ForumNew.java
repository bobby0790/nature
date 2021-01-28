package testcases.Forum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseTest;

public class ForumNew extends BaseTest
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
		sendkeys(TextForumTitle, ForumTitle);
		wait(3);
		sendkeys(TextForumDescription, Description);
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
		clickElement(ClickForumPublish);
		wait(1);
		if(driver.findElement(By.xpath("//span[text()='Please enter the title']")).isDisplayed())
		{
			/*String TitleErrorMessage=driver.findElement(By.xpath("//span[text()='Please enter the title']")).getText();
			System.out.println(TitleErrorMessage);
			wait(2);*/
			sendkeys(TextForumTitle, ForumTitle1);
			wait(2);
			clickElement(ClickForumPublish);
			wait(2);	
		}
		/*else if(driver.findElement(By.xpath("//span[text()='Please enter the title']")).isDisplayed())
		{
			String TitleErrorMessage=driver.findElement(By.xpath("//span[text()='Please enter the title']")).getText();
			System.out.println(TitleErrorMessage);
			wait(2);
			sendkeys(TextForumTitle, ForumTitle1);
			wait(2);
			clickElement(ClickForumPublish);
			wait(2);	
		}
		*/
		else if(driver.findElement(By.xpath("//span[text()='Please enter the description']")).isDisplayed())
		{
			/*String descriptionErrorMessage=driver.findElement(By.xpath("//span[text()='Please enter the description']")).getText();
			System.out.println(descriptionErrorMessage);
			wait(2);*/
			sendkeys(TextForumDescription, Description1);
			wait(2);
			clickElement(ClickForumPublish);
			wait(2);
		}
		else if(driver.findElement(By.xpath("//span[text()='Add at least 1 hashtag']")).isDisplayed())
		{
			/*String hashTagsErrorMessage=driver.findElement(By.xpath("//span[text()='Add at least 1 hashtag']")).getText();
			System.out.println(hashTagsErrorMessage);
			wait(2);
			*/
			String []hashtag=new String[]{HashTags7,HashTags8,HashTags9,HashTags10};
			for(int j=0;j<4;j++)
			{
				if(hashtag[j]!="")
				{
					WebElement dri=driver.findElement(By.xpath("//input[@class='ReactTags__tagInputField']"));
					dri.sendKeys(hashtag[j]);
					dri.sendKeys(Keys.ENTER);
				}
			}
			clickElement(ClickForumPublish);
			wait(2);
		}
		else if(driver.findElement(By.xpath("//div[text()='This forum title already exists. Try using another title.']")).isDisplayed())
		{
			/*String duplicateTitle=driver.findElement(By.xpath("//div[text()='This forum title already exists. Try using another title.']")).getText();
			System.out.println(duplicateTitle);
			wait(2);*/
			clearElement(TextForumTitle);
			wait(2);
			sendkeys(TextForumTitle, ForumTitle1);
			wait(2);
			clickElement(ClickForumPublish);
			wait(2);
		}
		else
		//else if(driver.findElement(By.xpath("//span[text()=\"Your forum '"+"ForumTitle"+"' is created successfully\"]")).isDisplayed())
		{
			System.out.println("Your forum" + ForumTitle +"is created Successfully");
			wait(2);
			driver.close();
		}
		
	}
}
