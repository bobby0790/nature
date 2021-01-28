package testcases.ProfileEditPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseTest;

public class CircleCreation extends BaseTest
{
	@Test(dataProvider="getData")
	public void circlecreation(String tdid, String username, String password, String CircleTitle, String Persona,String CircleCountry, String CircleState, String CircleCity, String Description, String Date, String memberList1,String memberList2, String memberList3, String memberList4, String memberList5) throws Exception
	{
		test = extent.createTest("Circle Creation");
		test.pass("Start the Browser");
		initiateBrowser();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		clickElement(LoginBtn);
		wait(2);
		sendKeys(TextUserName,username);
		wait(2);
		sendkeys(TextPassword,password);
		wait(2);
		clickElement(ClickLoginBtn);
		wait(3);
		clickElement(ClickProfile);
		wait(3);
		clickElement(ClickEditProfile);
		wait(2);
		clickElement(ClickLeftMenuCircle);
		wait(2);
		clickElement(ClickCreateCircle);
		//WebElement element=driver.findElement(By.xpath("//a[@href='#creatMicroCommunitypop']"));
		/*js.executeScript("window.scrollBy(0,3000)");
		wait(5);*/
		//js.executeScript("arguments[0].scrollIntoView();", element);
		wait(2);
		sendkeys(TextCircleTitle, CircleTitle);
		wait(1);
		clickElement(ClickCirclePersona);
		wait(1);
		WebElement circlePersona=driver.findElement(By.xpath("//div[contains(@id,'react-select-11-option-')][text()='"+Persona+"']"));
		circlePersona.click();
		wait(1);
		clickElement(SelectCircleCountry);
		wait(2);
		WebElement countryname=driver.findElement(By.xpath("//div[contains(@id,'react-select-12-option-')][text()='"+CircleCountry+"']"));
		countryname.click();
		wait(1);
		clickElement(SelectCircleState);
		wait(1);
		WebElement statename=driver.findElement(By.xpath("//div[contains(@id,'react-select-13-option-')][text()='"+CircleState+"']"));
		statename.click();
		clickElement(SelectCircleCity);
		wait(2);
		WebElement cityname=driver.findElement(By.xpath("//div[contains(@id,'react-select-14-option-')][text()='"+CircleCity+"']"));
		cityname.click();
		wait(1);
		sendkeys(TextCircleDescription, Description);
		wait(1);
		/*driver.findElement(By.xpath("//input[@placeholder='Select Incorporation Date']")).clear();
		wait(2);
		sendkeys(TextIncorporationDate, Date);
		wait(1);*/
		//WebElement connects=driver.findElement(By.xpath("TextCirclePlaceHolder"));
		//sendKeys(SearchUserName, memberList1);
		String[] memberList=new String[]{ memberList1, memberList2, memberList3, memberList4, memberList5};
		for(int j=0;j<5;j++)
		{
			if(memberList[j]!="")
			driver.findElement(By.xpath("//div[@class='members']//h5[text()='"+memberList[j]+"']")).click();
		}
			
		/*List<WebElement> member=driver.findElements(By.xpath("//div[@id='mCSB_2_container']"));
		int numberOfElements=member.size();
		for(int j=1;j<numberOfElements;j++)
		{
			WebElement member1=driver.findElement(By.xpath("//div[@class='members'][text()='"+memberList+""+j+"']"));
			member1.click();
		}*/
		/*WebElement member1=driver.findElement(By.xpath("//div[@class='members'][text()='"+memberList1+"']"));
		member1.click();
		WebElement member2=driver.findElement(By.xpath("//div[@class='members'][text()='"+memberList2+"']"));
		member2.click();
		WebElement member3=driver.findElement(By.xpath("//div[@class='members'][text()='"+memberList3+"']"));
		member3.click();
		WebElement member4=driver.findElement(By.xpath("//div[@class='members'][text()='"+memberList4+"']"));
		member4.click();
		WebElement member5=driver.findElement(By.xpath("//div[@class='members'][text()='"+memberList5+"']"));
		member5.click();*/
		/*int numberOfElements=member.size();
		for(int j=1;j<numberOfElements;j++)
		{
			member=driver.findElements(By.xpath("//div[@class='members'][text()='"+memberList+"']"));
			member.get(j).click();
		}*/
		clickElement(ClickCircleSubmit);
		wait(5);		
	}
}
