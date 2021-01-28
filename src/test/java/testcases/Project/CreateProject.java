package testcases.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseTest;

public class CreateProject extends BaseTest
{
	@Test(dataProvider="getData")
	public void createProject(String tdid, String username, String password, String Title, String CompanyName, String WebSiteName, String BriefDescription, String DetailedDescription, String RolesAndResponsibilities, String CountryName, String StateName, String CityName, String StartDate, String Remuneration) throws Exception
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
		wait(3);
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
		wait(10);
	}
}
