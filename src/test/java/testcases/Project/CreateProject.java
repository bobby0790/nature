package testcases.Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseTest;

public class CreateProject extends BaseTest
{
	@Test(dataProvider="getData")
	public void createProject(String tdid, String username, String password, String Title, String CompanyName, String WebSiteName, String BriefDescription, String DetailedDescription, String RolesAndResponsibilities, String CountryName, String StateName, String CityName, String StartDate, String Remuneration, String LastDate, String NoOfOpenings, String Specilization, String Skills) throws Exception
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
		/*clickElement(ClickAttachment);
		robotMethod("D:\\Downloads\\Causes\\Bird Conservation.png");
		wait(1);*/
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
		clickElement(SelectProjectSpecilization);
		wait(5);
		List<WebElement> special=driver.findElements(By.xpath("(//ul[@class='optionContainer'])[3]"));
		System.out.println(special.size());
		WebElement specilization=driver.findElement(By.xpath("//*[text()='"+Specilization+"']"));
		specilization.click();
		wait(1);
		clickElement(SelectProjectSkills);
		wait(1);
		WebElement skills=driver.findElement(By.xpath("(//*[text()='"+Skills+"'])[4]"));
		skills.click();
		wait(10);
	}
}
