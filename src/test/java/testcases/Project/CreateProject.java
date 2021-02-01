package testcases.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import resources.BaseTest;

public class CreateProject extends BaseTest
{
	@Test(dataProvider="getData")
	public void createProject(String tdid, String username, String password, String Title, String CompanyName, String WebSiteName, String BriefDescription, String DetailedDescription, String RolesAndResponsibilities, String CountryName, String StateName, String CityName, String StartDate, String Remuneration, String LastDate, String NoOfOpenings, String Specilization, String Skills, String HashTags1, String HashTags2, String HashTags3, String HashTags4, String HashTags5, String HashTags6, String Qualification1, String Qualification2, String Qualification3, String Qualification4, String Qualification5, String Inclusions, String Exclusions, String Remarks, String MediaCoverage) throws Exception
	{
		test = extent.createTest("Post as Circle");
		test.pass("Start the Browser");
		initiateBrowser();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		clickElement(LoginBtn);
		wait(1);
		sendKeys(TextUserName,username);
		wait(1);
		sendkeys(TextPassword,password);
		wait(1);
		clickElement(ClickLoginBtn);
		wait(5);
		clickElement(ClickProject);
		wait(1);
		clickElement(clickAddNewProject);
		wait(1);
		clickElement(clickAddJob);
		wait(1);
		sendkeys(TextJobTitle, Title);
		wait(1);
		sendkeys(TextCompanyName, CompanyName);
		wait(1);
		sendKeys(TextWebSiteName, WebSiteName);
		wait(1);
		sendKeys(TextBriefDescription, BriefDescription);
		wait(1);
		sendkeys(TextDetailedDescription, DetailedDescription);
		wait(1);
		clickElement(ClickAttachment);
		robotMethod("D:\\Downloads\\Causes\\Bird Conservation.png");
		wait(1);
		sendkeys(TextRolesAndResponsibilities, RolesAndResponsibilities);
		wait(1);
		clickElement(SelectProjectCountry);
		wait(1);
		WebElement countryname=driver.findElement(By.xpath("//div[contains(@id,'react-select-2-option-')][text()='"+CountryName+"']"));
		countryname.click();
		wait(1);
		clickElement(SelectProjectState);
		wait(1);
		WebElement statename=driver.findElement(By.xpath("//div[contains(@id,'react-select-3-option-')][text()='"+StateName+"']"));
		statename.click();
		clickElement(SelectProjectCity);
		wait(1);
		WebElement cityname=driver.findElement(By.xpath("//div[contains(@id,'react-select-4-option-')][text()='"+CityName+"']"));
		cityname.click();
		wait(1);
		sendkeys(TextStartDate, StartDate);
		wait(1);
		sendkeys(TextRemuneration, Remuneration);
		wait(1);
		sendKeys(TextLastDate, LastDate);
		wait(1);
		sendkeys(TextNoOfOpenings, NoOfOpenings);
		wait(1);
		//WebElement special=driver.findElement(By.xpath("//label[text()='Specialization ']/..//input[@id='search_input']"));
		clickElement(SelectProjectSpecilization);
		wait(10);
		Actions action=new Actions(driver);
		//action.moveToElement(special).doubleClick().build().perform();*/
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+Specilization+"']/input")));
		//special.click();
		wait(10);
		WebElement spe=driver.findElement(By.xpath("//li[text()='"+Specilization+"']/input"));
		action=new Actions(driver);
		action.moveToElement(spe).click().build().perform();
		
		//Actions spe=new Actions(driver);
		//WebElement specilization=driver.findElement(By.xpath("//li[text()='"+Specilization+"']"));
		//specilization.click();
		//spe.moveToElement(specilization).click(specilization).build().perform();
		wait(1);
		clickElement(SelectProjectSkills);
		wait(1);
		WebElement skills=driver.findElement(By.xpath("(//li[text()='"+Skills+"'])[3]"));
		skills.click();
		wait(1);
		if(!HashTags1.equals("") || !HashTags2.equals("") || !HashTags3.equals("") || !HashTags4.equals("") || !HashTags5.equals("") || !HashTags6.equals(""))
		{
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
		}
		wait(1);
		String[] qualification=new String[]{ Qualification1, Qualification2, Qualification3, Qualification4, Qualification5};
		for(int j=0;j<5;j++)
		{
			if(qualification[j]!="")
			driver.findElement(By.xpath("//input[contains(@id,'qualification"+j+"')]")).sendKeys(qualification[j]);
			clickElement(ClickQualificationAddMore);
		}
		wait(1);
		sendkeys(TextInclusions, Inclusions);
		wait(1);
		sendkeys(TextExclusions, Exclusions);
		wait(1);
		sendkeys(TextRemarks, Remarks);
		wait(1);
		sendkeys(TextMediaCoverage, MediaCoverage);
		wait(1);
		Actions ac=new Actions(driver);
		WebElement element=driver.findElement(By.xpath("//div[@class='custom-control custom-checkbox']//input[@name='isAgree']"));
		ac.moveToElement(element).click(element).build().perform();
		wait(1);
		clickElement(ClickPublish);
		wait(3);
	}

}
