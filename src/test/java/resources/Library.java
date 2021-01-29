package resources;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Library extends Config
{
	//create extent Html reports
			public static ExtentHtmlReporter htmlReporter;
			//create extent reports
			public static ExtentReports extent;
			// create extent test
			public static ExtentTest test;
			//create driver
			public WebDriver driver;
			
			// To create extent html file
			@BeforeSuite
			public void startSuite() 
			{
				
				htmlReporter =new ExtentHtmlReporter(reportPath+"extent-report.html");
				extent= new ExtentReports();
				extent.attachReporter(htmlReporter);
				extent.setSystemInfo("OS", "Windows 10");
				extent.setSystemInfo("HostName", "Localhost");
				extent.setSystemInfo("UserName", "Durga");
				extent.setSystemInfo("Browser", "Chrome");
				extent.setSystemInfo("Browser Version", "87");
				
				htmlReporter.config().setChartVisibilityOnOpen(true);
				htmlReporter.config().setDocumentTitle("Automation Report");
				htmlReporter.config().setReportName("Regression Cycle");
				htmlReporter.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");
				
				
			}
			

			@AfterSuite
			public void endSuite() throws IOException 
			{
				extent.flush();	
			}
			
			public void initiateBrowser()
			{
				if(browser.equalsIgnoreCase("FireFox")) 
				{
					driver=new FirefoxDriver();
					test.pass("Browser opened");
				}
				else if (browser.equalsIgnoreCase("Chrome")) 
				{
					System.setProperty("webdriver.chrome.driver","D:/WorkSpace/WeNaturalists/SetupFile/chromedriver.exe");
					driver=new ChromeDriver();
					test.pass("Browser opened");	
				}
				else
				{
					System.setProperty("webdriver.ie.driver","D:/WorkSpace/WeNaturalists/SetupFile/IEDriverServer.exe");
					driver=new InternetExplorerDriver();
					test.pass("Browser opened");
				}
				
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				test.pass("navigate to "+ url);
				
			}
			
			public void robotMethod(String data) throws Exception
			{
				Robot robot=new Robot();
				robot.setAutoDelay(1000);
				StringSelection stringselection=new StringSelection(data);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
				robot.setAutoDelay(1000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.setAutoDelay(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
			}
			
			public void robotMethodMultiple() throws Exception
			{
				Robot robot=new Robot();
				robot.setAutoDelay(3000);
				File folder = new File("D:\\Downloads\\Causes");
			    File[] files = folder.listFiles();
			    String filesList = "";
			    for(int i = 0; i < files.length; i++)
			    {
			        filesList += (i != 0? "\n":"") + files[i].getAbsolutePath();
			      //StringSelection sel  = new StringSelection(filesList);
			        StringSelection stringselection=new StringSelection(filesList);
				//StringSelection stringselection=new StringSelection(filesList);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
			    
				robot.setAutoDelay(3000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.setAutoDelay(3000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			    }
			}
			
			
			public void sendkeys(By locator, String text) throws InterruptedException
			{
				try 
				{
					driver.findElement(locator).sendKeys(text);
					test.pass("entered text "+ text + "in"+ locator);
				}
				catch (Exception e) 
				{	
					System.out.println("unable to send text for the element "+e);
				}
			}
			
			
			public void clickElement(By element)
			{
				try 
				{
					driver.findElement(element).click();
					test.pass("clicked " + element);
				}
				catch (Exception e) 
				{
					System.out.println("unable to click an element "+e);
				}
			}
			
			public void clearElement(By element)
			{
				try 
				{
					driver.findElement(element).clear();
					test.pass("clicked " + element);
				}
				catch (Exception e) 
				{
					System.out.println("unable to click an element "+e);
				}
			}

			public void sendKeys(By textEmail, String text) throws InterruptedException
			{
				try 
				{
					driver.findElement(textEmail).sendKeys(text);
					test.pass("entered '"+text+"' in "+ textEmail);
				}
				catch (Exception e) 
				{
					System.out.println("unable to send text to the element "+e);
				}	

			}


			public void captureScreenshot() throws IOException
			{

				// Take screenshot and store in temp file
				File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				String screenShotName = this.getClass().getSimpleName()+".png";
				
				String screenShotFilePath = screenshotsPath+screenShotName;

				// declare the destination file path
				File destination = new File(screenShotFilePath);

				//copy the screenshot file from source to the destination
				FileUtils.copyFile(source, destination);

			}

			/*public void excelSheet()
			{
				FileInputStream fin = null;
			try
			{
				fin=new FileInputStream("D:\\Users\\Pritam\\eclipse-workspace\\LyveProject\\src\\test\\java\\suites\\login.xlsx");
			}
			catch (FileNotFoundException e) 
			{
				System.out.println(" file not found "+e);
			}
			XSSFWorkbook wb = null;
			try 
			{
				wb = new XSSFWorkbook(fin);
			}
			catch (IOException e) 
			{
			System.out.println("file not found"+e);
			}
			XSSFSheet ws=wb.getSheet("Sheet1");
			Row row;
			Cell cell;
			
			for(int r=1;r<=ws.getLastRowNum();r++)
			{
				row=ws.getRow(r);
			}
			}*/
			
			public void quitBrowser()
			{
				try 
				{
					driver.quit();
					test.pass("quit the browser");
				}
				catch (Exception e) 
				{
					System.out.println("unable to close the browser " +e);
				}
			}
			
			public void isEnabled(By element)
			{
				try 
				{
					if(driver.findElement(element).isEnabled())
					{
						test.pass("visuable " +element);
					}
				}
				catch (Exception e) 
				{
					System.out.println("Element is not visuable " +e);
				}
			}
			
			public void isEnable(By element, By element1)
			{
				try 
				{
					if(driver.findElement(element).isEnabled())
					{
						test.pass("visuable " +element);
						String msg=driver.findElement(element1).getText();
						System.out.println(msg);
					}
				}
				catch (Exception e) 
				{
					System.out.println("Element is not visuable " +e);
				}
			}
			
			public void isDisplayed(By element)
			{
				try
				{
					if(driver.findElement(element).isDisplayed())
					{
						test.pass("displayed " +element);
						String msg=driver.findElement(element).getText();
						System.out.println(msg);
					}
				}
				catch (Exception e)
				{
					System.out.println("Element is not dispalyed " +e);
				}
			}
			
			public void ifelse(By element, By element1, By element2)
			{
				if(driver.findElement(element).isDisplayed())
				{
					test.pass("displayed " +element);
					String msg=driver.findElement(element).getText();
					System.out.println(msg);
				}
				else
				{
					try
					{
						if(driver.findElement(element1).isDisplayed())
						{
							test.pass("displayed " +element1);
							System.out.println("Please Enter Valid email id and password");
						}
					}
					catch(Exception e)
					{
						if(driver.findElement(element2).isDisplayed())
						{
							test.pass("displayed " +element2);
						}
					}
				}
			}
			public void isVerified(By element)
			{
				try
				{
					if(driver.findElement(element).isDisplayed())
					{
						test.pass("displayed " +element);
					}
				}
				catch (Exception e)
				{
					System.out.println("Element is not dispalyed " +e);
				}
			}
			
			public void elseIf(By element ,By element1)
			{
				try
				{
					if(driver.findElement(element).isDisplayed())
					{
						test.pass("displayed " +element);
						String msg=driver.findElement(element).getText();
						System.out.println(msg);
					}
					else if(driver.findElement(element1).isDisplayed())
					{
						test.pass("displayed " + element1);
						String msg1=driver.findElement(element1).getText();
						System.out.println(msg1);
						System.out.println("Please enter your valid email id and password");
					}
				}
				catch (Exception e)
				{
					System.out.println("Element is not dispalyed " +e);
				}
			}
			
			public void action(By element ,By element1) throws Exception
			{
				Actions ac=new Actions(driver);
				WebElement menu=driver.findElement(element);
				ac.moveToElement(menu).build().perform();
				test.pass("move to an element" +element);
				Thread.sleep(5000);
				driver.findElement(element1).click();
				test.pass("clicked on element" +element1);
			}
			
			public void wait(int sec) throws InterruptedException
			{
				Thread.sleep(sec*1000);
			}
			
			public String genRandomNum(int min, int max)
			{
				String num=Double.toString(min+(Math.random()*(max-min)));
				num=num.substring(0, num.indexOf("."));
				if (Integer.parseInt(num)<10)
				{
					num="0"+num;
				}
				return num;
			}
			
			
			public void ewait(By element)
			{
				WebDriverWait wait=new WebDriverWait(driver, 30);
				
				WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(element));
				
				boolean status=ele.isDisplayed();
				
				if (status) 
				{
					System.out.println("webElement is visible for "+element);
				}
				else
				{
					System.out.println("webelement is not visible for "+element);
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
