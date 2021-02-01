package resources;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;

public class Properties extends Xlsreader
{
	public By LoginBtn=By.xpath("(//a[@href='/login'])[2]");
	
	public By TextUserName=By.id("email");
	
	public By TextPassword=By.id("passwrd");
	
	public By ClickLoginBtn=By.xpath("//button[text()='Log in']");
	
	public By ClickForum=By.xpath("//a[@href='/forum']");
	
	public By ClickAddForum=By.xpath("//span[text()='Add Forum']");
	
	public By TextForumTitle=By.id("title");
	
	public By TextForumDescription=By.xpath("(//div[@class='ql-editor ql-blank'])[2]");
	
	public By TextForumHashTags=By.xpath("//input[@class='ReactTags__tagInputField']");
	
	public By ClickForumPublish=By.xpath("//button[text()='PUBLISH']");
	
	public By ClickPoll=By.xpath("//a[@href='/poll']");
	
	public By ClickAddPoll=By.xpath("//span[text()='Add Poll']");
	
	public By PollErrorMessage=By.xpath("//span[text()='Please enter a valid poll question']");
	
	public By TextPollQuestion=By.xpath("//textarea[@id='pollQuestion']");
	
	public By OptionErrorMessage=By.xpath("//span[text()='Please enter an option']");
	
	public By TextPollOptionOne=By.xpath("(//input[@class='form-control'])[4]");
	
	public By TextPollOptionTwo=By.xpath("(//input[@class='form-control'])[5]");
	
	public By StartDateErrorMessage=By.xpath("//span[text()='Please enter the start date']");
	
	public By EndDateErrorMessage=By.xpath("//span[text()='Please enter the end date']");
	
	public By TextPollStartDate=By.xpath("//input[@placeholder='Start Date']");
	
	public By TextPollEndDate=By.xpath("//input[@placeholder='End Date']");
	
	public By DuplicatePollErrorMessage=By.xpath("//span[text()='This poll title already exists. Try using another title.']");
	
	public By SucessPoll=By.xpath("//span[text()='Your poll Automate poll test  is created successfully!']");
	
	public By AdditionalOptionErrorMessage=By.xpath("//span[text()='Please enter an option. You may also remove the option.']");
	
	public By ClickPollPublish=By.xpath("//button[text()='PUBLISH']");
	
	public By ClickPost=By.xpath("//button[text()='Post Something New!']");
	
	public By ClickPostDropDown=By.xpath("(//button[@class='btn dropdown-toggle'])[1]");
	
	public By ClickCircleDropDown=By.xpath("(//li[@class='dropdown-item dropdown-submenu'])[4]");
	
	public By ClickCircle=By.xpath("(//h5[text()='Rotary club'])[1]");
	
	public By TextPostDescription=By.id("input_box");
	
	public By TextPostHashTags=By.id("colon");
	
	public By ClickPostButton=By.xpath("(//input[@value='POST'])[1]");
	
	public By ClickPostImageBtn=By.xpath("//a[@title='Upload Images']");
	
	public By ClickPostImagePreviewClose=By.xpath("(//button[@class='close'])[2]");
	
	public By ClickSignUp=By.xpath("//a[text()='Signup']");
	
	public By TextFirstName=By.xpath("(//input[@type='text'])[1]");
	
	public By TextLastName=By.xpath("(//input[@type='text'])[2]");
	
	public By CountryMenuList=By.xpath("//div[@class='react-select__menu-list css-11unzgr']");
	
	public By ClickCountryCode=By.xpath("//div[contains(@class,' css-2b097c-container')]");
	
	public By ClickCountry=By.xpath("//div[text()= '🇨🇦 +1 Canada']");
	
	public By TextPhoneNumber=By.id("validationCustomUsername");
	
	public By TextEmail=By.xpath("//input[@id='email']");
	
	public By TextSignPassword=By.xpath("//input[@type='password']");
	
	public By ClickAgree=By.xpath("//button[@type='submit']");
	
	public By TextOtp=By.xpath("//input[@class='OTP']");
	
	public By ClickOtpSubmit=By.xpath("//button[@class='login-btn btn btn-primary mt-3']");
	
	public By SelectCountry=By.xpath("//div[text()='Select Country *']");
	
	public By SelectCountryName=By.xpath("//div[@id='react-select-3-option-31']");
	
	public By SelectState=By.xpath("//div[text()='Select State *']");
	
	public By SelectCity=By.xpath("//div[text()='Select City *']");
	
	public By ClickAddressSubmit=By.xpath("//button[text()='Next']");
	
	public By SelectStateName=By.xpath("//div[@id='react-select-4-option-1']");
	
	public By ClickSkills=By.xpath("(//div[@class='_2iA8p44d0WZ-WqRBGcAuEV '])[1]");
	
	public By ClickInterests=By.xpath("(//div[@class='_2iA8p44d0WZ-WqRBGcAuEV '])[2]");
	
	public By ClickPersonalSubmit=By.xpath("//button[text()='Next']");
	
	public By ClickMenu=By.xpath("//div[@class='usermenu']//button[@type='button']");
	
	public By ClickProfile=By.xpath("//a[@class='userprofile btn']");
	
	public By ClickEditProfile=By.xpath("//div[@class='edtbtn btn']");
	
	public By ClickLeftMenuCircle=By.xpath("//a[@href='#circleSec']");
	
	public By ClickCreateCircle=By.xpath("(//a[@class='adddtlsbtn btn'])[3]");
	
	public By TextCircleTitle=By.xpath("//input[@placeholder='Circle title']");
	
	public By ClickCirclePersona=By.xpath("(//div[@class=' css-2b097c-container'])[11]");
	
	public By SelectCircleCountry=By.xpath("(//div[@class=' css-2b097c-container'])[12]");
	
	public By SelectCircleState=By.xpath("(//div[@class=' css-2b097c-container'])[13]");
	
	public By SelectCircleCity=By.xpath("(//div[@class=' css-2b097c-container'])[14]");
	
	public By SearchUserName=By.xpath("//div[@class='search2']//input[@type='text']");
	
	public By TextCircleDescription=By.xpath("(//textarea[@placeholder='Write here...'])[5]");
	
	public By TextIncorporationDate=By.xpath("//input[@placeholder='Select Incorporation Date']");
	
	public By clearDate=By.xpath("(//div[@class='react-datepicker__input-container'])[10]");
	
	public By TextCirclePlaceHolder=By.xpath("//input[@placeholder='Type connect name']");
	
	public By ClickCircleSubmit=By.xpath("(//button[text()='Continue'])[6]");
	
	public By ClickProject=By.xpath("(//a[@href='/project'])[1]");
	
	public By clickAddNewProject=By.xpath("//span[text()='Add New']");
	
	public By clickAddJob=By.xpath("//a[text()='Job']");
	
	public By TextJobTitle=By.xpath("//input[@name='title']");
	
	public By TextCompanyName=By.xpath("//input[@name='companyName']");
	
	public By TextWebSiteName=By.xpath("//input[@name='website']");
	
	public By TextBriefDescription=By.xpath("//textarea[@name='shortBrief']");
	
	public By TextDetailedDescription=By.xpath("//textarea[@name='detailedDescription']");
	
	public By ClickAttachment=By.xpath("//a[@class='attachfile']");
	
	public By TextRolesAndResponsibilities=By.xpath("//textarea[@name='role']");
	
	public By SelectProjectCountry=By.xpath("(//div[@class=' css-1hwfws3'])[1]");
	
	public By SelectProjectState=By.xpath("(//div[@class=' css-1hwfws3'])[2]");
	
	public By SelectProjectCity=By.xpath("(//div[@class=' css-1hwfws3'])[3]");
	
	public By TextStartDate=By.xpath("//input[@name='durationStartDate']");
	
	public By TextRemuneration=By.xpath("//input[@type='number'][@placeholder='Amount']");
	
	public By TextLastDate=By.xpath("//input[@name='applnEndDate']");
	
	public By TextNoOfOpenings=By.xpath("//input[@name='noOfOpenings']");
	
	public By SelectProjectSpecilization=By.xpath("//label[text()='Specialization ']/..//input[@id='search_input']");
	
	public By SelectProjectSkills=By.xpath("(//input[@id='search_input'])[4]");
	
	public By ClickQualificationAddMore=By.xpath("//a[@class='addmore']");
	
	public By TextInclusions=By.xpath("//textarea[@name='inclusions']");
	
	public By TextExclusions=By.xpath("//textarea[@name='exclusions']");
	
	public By TextRemarks=By.xpath("//textarea[@name='endTakeAway']");
	
	public By TextMediaCoverage=By.xpath("//input[@name='medias']");
	
	public By ClickProAgree=By.xpath("//div[@class='custom-control custom-checkbox']//input[@name='isAgree']");
	
	public By ClickPublish=By.xpath("(//button[text()='Publish'])[2]");
	
	public By ClickSignOut=By.xpath("//a[text()='Sign Out']");
	
	public By ClickLoginSP=By.xpath("//input[@type='tel']");
	
	public By ClickOtpSP=By.xpath("(//button[text()='Send OTP'])[1]");
	
	public By TextotpSp=By.xpath("//div[@class='wrapper']//div[@class='inner-wrap']//input");
	
	public By ClickLoginSp=By.xpath("//div[@class='button']//button[text()='Log In']");
	
	public By ClickContractButton=By.xpath("//a[@href='/app/contracts']");
	
	public By ClickDropDown=By.xpath("//div[@class='css-vj8t7z']");
	
	public By SelectCity1=By.xpath("//div[contains(text(),'Kolkata2')]");
	
	public By ClickCreate=By.xpath("(//a[@class='dropdown-toggle nav-link'])[1]");
	
	public By ClickCreateContract=By.xpath("//button[text()='Contract']");
}
