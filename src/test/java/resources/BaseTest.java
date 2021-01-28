package resources;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Properties
{
	@BeforeMethod
	public void startTest() throws Exception
	{
		//Get the full path of the package of the current class	
		String packagePath=this.getClass().getPackage().getName();
		
		String packages=packagePath.substring(packagePath.lastIndexOf(".")+1);
		
		String file=testDataPath+packages+".xlsx";
		
		String testCase=this.getClass().getSimpleName();
		
		if(!IsTCRunnable(file, "TestCases",testCase)) {
			test = extent.createTest(testCase);
			test.skip("Skipping the test case ");
			throw new SkipException("Skipping the test case ");
		}
	}
	
	@AfterMethod
	public void endTest(ITestResult result) throws IOException 
	{

		if(result.getStatus() == ITestResult.FAILURE)
		{
			 captureScreenshot();
			 test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			
			 
		}
		quitBrowser();
	}
}
