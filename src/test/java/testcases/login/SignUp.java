package testcases.login;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import resources.BaseTest;

public class SignUp extends BaseTest
{
	@Test(dataProvider="getData")
	public void signup(String tdid, String firstName, String lastName, String CountryCode, String PhoneNumber, String Email, String password, String CountryName, String StateName, String CityName, String Persona, String Skills, String Interests ) throws Exception
	{
		test = extent.createTest("signup");
		test.pass("Start the Browser");
		initiateBrowser();
		clickElement(ClickSignUp);
		wait(3);
		sendkeys(TextFirstName, firstName);
		wait(1);
		sendkeys(TextLastName, lastName);
		wait(1);
		clickElement(ClickCountryCode);
		wait(2);
		WebElement code=driver.findElement(By.xpath("//div[contains(@id,'react-select-2-option-')][text()='"+CountryCode+"']"));
		code.click();
		sendkeys(TextPhoneNumber, PhoneNumber);
		wait(1);
		/*Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		String randomName = RandomStringUtils.randomAlphanumeric(8);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys( randomName + randomInt +"@yopmail.com");*/
		sendkeys(TextEmail, Email);
		wait(2);
		sendkeys(TextSignPassword, password);
		wait(1);
		clickElement(ClickAgree);
		wait(2);
		if(driver.findElement(By.xpath("//h1[text()='Authentication']")).isDisplayed())
		{
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please enter your OTP");
		String OTP = scan1.nextLine();
		sendkeys(TextOtp, OTP);
		wait(1);
		clickElement(ClickOtpSubmit);
		wait(2);
		clickElement(SelectCountry);
		wait(2);
		WebElement countryname=driver.findElement(By.xpath("//div[contains(@id,'react-select-3-option-')][text()='"+CountryName+"']"));
		countryname.click();
		wait(1);
		clickElement(SelectState);
		wait(1);
		WebElement statename=driver.findElement(By.xpath("//div[contains(@id,'react-select-4-option-')][text()='"+StateName+"']"));
		statename.click();
		clickElement(SelectCity);
		wait(2);
		WebElement cityname=driver.findElement(By.xpath("//div[contains(@id,'react-select-5-option-')][text()='"+CityName+"']"));
		cityname.click();
		wait(1);
		clickElement(ClickAddressSubmit);
		wait(2);
		Select persona=new Select(driver.findElement(By.xpath("//select[@name='city']")));
		persona.selectByVisibleText(Persona);
		wait(1);
		clickElement(ClickSkills);
		wait(1);
		WebElement skills=driver.findElement(By.xpath("//li[text()='"+Skills+"']"));
		skills.click();
		wait(1);
		clickElement(ClickInterests);
		wait(1);
		WebElement interests=driver.findElement(By.xpath("//li[text()='"+Interests+"']"));
		interests.click();
		wait(1);
		clickElement(ClickPersonalSubmit);
		wait(2);
		clickElement(ClickMenu);
		wait(2);
		clickElement(ClickSignOut);
		}
		else if(driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div/div/form/span")).isDisplayed())
		{
			System.out.println("This phone number is already registered. Please try using a different number.");
			driver.close();
			
		}
		else
		{
			driver.close();
		}
		
		/*List<WebElement> element=driver.findElements(By.xpath("//div[contains(@id,'react-select-2-option-')]"));
		int numberOfElements=element.size();
		for(int i=0;i<numberOfElements;i++)
		{
			
			if (element.get(i).getText().contains(CountryCode))
			{	
				wait(2);
				element.get(i).click();	
			}
	
				
			if(driver.findElement(By.id("react-select-2-option-"+"i")).equals(CountryCode))
			{
				wait(2);
				elements=driver.findElements(By.id("react-select-2-option-"+i));
				wait(2);
				elements.get(i).click();
			}
				
		}
	*///	wait(10);
		/*clickElement(ClickCountryCode);
		wait(2);
		clickElement(ClickCountry);
		wait(2);*/
		
	}
}
