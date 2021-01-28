package resources;

public class Config 
{
	//create base path
	public String basePath=System.getProperty("user.dir")+"\\src\\test\\java\\";

	//create report path
	public String reportPath=basePath+"report\\";
	
	//create screenshot path
	public String screenshotsPath=reportPath+"Screenshot\\";
	
	//create suites path
	public String suitesPath=basePath+"Suites\\";
	
	public String testDataPath=suitesPath;
	
	public String testcasesPath=basePath+"testcases\\";
	//project url 
	public String url="http://dev.wenat.beegram.in/";
	
	//choose browser
	public String browser="chrome";

}
