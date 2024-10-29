package expenseTravog;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class Login {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("UserLogin", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void LoginProcess(String TestCaseId, String TestScenario, String ccode, String URL, String Emailid,
			String Password) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaExtentReport.extentScreenshot("Dashboard");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("expenlogin");
		QaRobot.PassValue("loginemailexp", Emailid);
		QaRobot.PassValue("loginpasswordexp", Password);
		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("Clickonexplogin");
		QaExtentReport.extentScreenshot("Dashboard");
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}
}
