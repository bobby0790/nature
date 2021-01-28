package testcases.Poll;

import org.testng.annotations.Test;

import resources.BaseTest;

public class Poll extends BaseTest
{
	@Test(dataProvider="getData")
	public void poll(String tdid, String username, String password, String PollQuestion, String QuestionOne, String QuestionTwo, String StartDate, String EndDate) throws Exception
	{
		test = extent.createTest("Poll Creation");
		test.pass("Start the Browser");
		initiateBrowser();
		clickElement(LoginBtn);
		wait(3);
		sendKeys(TextUserName,username);
		wait(3);
		sendkeys(TextPassword,password);
		wait(3);
		clickElement(ClickLoginBtn);
		wait(5);
		clickElement(ClickPoll);
		wait(2);
		clickElement(ClickAddPoll);
		wait(2);
		sendkeys(TextPollQuestion, PollQuestion);
		wait(1);
		sendkeys(TextPollOptionOne, QuestionOne);
		wait(1);
		sendkeys(TextPollOptionTwo, QuestionTwo);
		wait(1);
		sendkeys(TextPollStartDate, StartDate);
		wait(1);
		sendkeys(TextPollEndDate, EndDate);
		wait(1);
		clickElement(ClickPollPublish);
		wait(3);
	}

}
