package testcases.PostModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseTest;

public class PostAsCircle extends BaseTest
{
	@Test(dataProvider="getData")
	public void postascircle(String tdid, String username, String password,String CircleTitle, String PostDescription, String PostHashTags1, String PostHashTags2, String PostHashTags3, String PostHashTags4, String PostHashTags5, String PostHashTags6) throws Exception
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
		clickElement(ClickPost);
		wait(1);
		clickElement(ClickPostDropDown);
		wait(1);
		clickElement(ClickCircleDropDown);
		wait(1);
		WebElement circletitle=driver.findElement(By.xpath("(//h5[text()='"+CircleTitle+"'])[1]"));
		circletitle.click();
		wait(1);
		clickElement(ClickPostButton);
		wait(1);
		if(isDisplayed("//span[text()='Please Post something to publish']"))
		{
		if(!PostDescription.equals(""))
		{
			sendkeys(TextPostDescription,PostDescription);
			wait(1);
		}
		if(!PostHashTags1.equals("") || !PostHashTags2.equals("") || !PostHashTags3.equals("") || !PostHashTags4.equals("") || !PostHashTags5.equals("") || !PostHashTags6.equals(""))
		{
			String []Posthashtags=new String[]{PostHashTags1,PostHashTags2,PostHashTags3,PostHashTags4,PostHashTags5,PostHashTags6};
			for(int j=0;j<6;j++)
			{
				if(Posthashtags[j]!="")
				{
					WebElement dri=driver.findElement(By.id("colon"));
					dri.sendKeys(Posthashtags[j]);
					dri.sendKeys(Keys.ENTER);
					
				}
			}
		}
		wait(1);
		clickElement(ClickPostButton);
		wait(1);
	}
		if(circletitle!=ClickPostDropDown)
			driver.close();
	}
}
