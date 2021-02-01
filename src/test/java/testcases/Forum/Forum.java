package testcases.Forum;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.BaseTest;

public class Forum extends BaseTest
{
	@DataProvider
	public Object[][] readData() throws Exception
	{
		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File("./src/test/java/suites/forum.xlsx")));
		XSSFSheet sheet=workbook.getSheet("Forum");
		int rowcount=sheet.getLastRowNum();
		Object[][] obj=new Object[rowcount][19];
		for(int i=1; i< rowcount; i++)
		{
			Row row=sheet.getRow(i);
			System.out.println(row.getLastCellNum());
			for(int j=0;j<18;j++)
			{
				row=sheet.getRow(i);
				Cell cell=row.getCell(j);
				System.out.println(i+" "+j);
				obj[i][j]=cell.getStringCellValue();
			}
			obj[i][18]=""+i;
			
		}
		return obj;
	}
	@Test(dataProvider="getData")
	public void forum(String tdid, String username, String password, String ForumTitle, String Description, String HashTags1, String HashTags2, String HashTags3, String HashTags4, String HashTags5, String HashTags6, String ForumTitle1, String Description1, String HashTags7, String HashTags8, String HashTags9, String HashTags10, String Status) throws Exception
	{
		/*String FilePath="./src/test/java/suites/forum.xlsx";
		String sheetname="Forum";
		String colName="Status";
		addColumn(FilePath, sheetname, colName);
	//	int rowCount=getRowCount(FilePath, sheetname);
		*//*for(int rowNumber=2;rowNumber<rowCount;rowNumber++)
		{
		*/
		//System.out.println(rowNum);
		test = extent.createTest("Forum");
		test.pass("Start the Browser");
		initiateBrowser();
		clickElement(LoginBtn);
		wait(3);
		sendKeys(TextUserName,username);
		wait(2);
		sendkeys(TextPassword,password);
		wait(2);
		clickElement(ClickLoginBtn);
		wait(1);
		clickElement(ClickForum);
		wait(1);
		clickElement(ClickAddForum);
		wait(1);
		clickElement(ClickForumPublish);
		wait(1);
		if(isDisplayed("//span[text()='Please enter the title']") && isDisplayed("//span[text()='Please enter the description']") && isDisplayed("//span[text()='Add at least 1 hashtag']"))
		{
			if(!ForumTitle.equals(""))
			{
				sendkeys(TextForumTitle,ForumTitle);
				wait(1);
			}
			if(!Description.equals(""))
			{
				sendkeys(TextForumDescription,Description);
				wait(1);
			}
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
			clickElement(ClickForumPublish);
			//wait(1);
			if(isDisplayed("//span[text()='Please enter the title']") || isDisplayed("//div[text()='This forum title already exists. Try using another title.']"))
			{
				sendkeys(TextForumTitle,ForumTitle1);
				//wait(2);
			}
			if(Description.equals(""))
			{
			if(isDisplayed("//span[text()='Please enter the description']"))
				{
					sendkeys(TextForumDescription,Description1);
					//wait(2);
				}
			}
			if(HashTags1.equals("") && HashTags2.equals("") && HashTags3.equals("") && HashTags4.equals("") && HashTags5.equals("") && HashTags6.equals(""))
			{
				if(driver.findElement(By.xpath("//span[text()='Add at least 1 hashtag']")).isDisplayed())
				{
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
				}
			}
			clickElement(ClickForumPublish);
			wait(2);
			System.out.println("Your forum " + ForumTitle + " is created Successfully");
		//	setcellData(FilePath, sheetname, colName, rowNumber, "Pass");
			//setCellData(FilePath,sheetname, 19, 19,"Pass");
		
			if(isDisplayed("//span[text()=\"Your forum '"+ForumTitle+"' is created successfully\"]")||isDisplayed("//span[text()=\"Your forum '"+ForumTitle1+"' is created successfully\"]"))
			{
				System.out.println("Your forum" + ForumTitle + "is created Successfully");
				//setCellData("./src/test/java/suites/forum.xlsx",sheetname, 20, 20,"Pass");
				System.out.println("Your forum" + ForumTitle + "is created Successfully" + "last");
				wait(2);
				driver.close();
			}
			//}
		}
	}	
}
