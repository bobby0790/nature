package testcases.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import resources.BaseTest;

public class SuperProcure extends BaseTest
{
	@Test
	
	public void login() throws Exception
	{
		test = extent.createTest("Login");
		test.pass("Start the Browser");
		initiateBrowser();
		wait(30);
		sendkeys(ClickLoginSP, "9830524546");
		wait(3);
		clickElement(ClickOtpSP);
		wait(5);
		sendkeys(TextotpSp, "98878");
		wait(3);
		clickElement(ClickLoginSp);
		wait(5);
		clickElement(ClickContractButton);
		wait(5);
		clickElement(ClickDropDown);
		wait(2);
		clickElement(SelectCity);
		wait(5);
		clickElement(ClickCreate);
		wait(2);
		clickElement(ClickCreateContract);
		wait(2);
		
		
		
		
		/*Actions act = new Actions(driver);//driver variable is chrome web driver ref

		WebElement selectInput=driver.findElement(By.xpath("//div[@class='css-vj8t7z']"));
		Thread.sleep(5000);

		act.click(selectInput).build().perform();
		Thread.sleep(5000);

		//list of all option
		List<WebElement> selectValues=driver.findElements(By.xpath("//div[@class='css-vj8t7z']"));
		Thread.sleep(5000);

		//first option:
		WebElement firstWebElement=selectValues.get(1);
		Thread.sleep(5000);

		act.click(firstWebElement).build().perform();
		Thread.sleep(5000);*/
	}

}
