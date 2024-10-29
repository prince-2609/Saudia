package expenseTravog;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class DeleteExpenseSheet {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("DeleteExpenseTrip", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void ExpenseManagement(String TestCaseId, String TestScenario, String ccode, String URL,
			String Emailid, String Password, String TripQty, String TripName) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		QaRobot.ClickOnElement("expenlogin");
		QaRobot.PassValue("loginemailexp", Emailid);
		QaRobot.PassValue("loginpasswordexp", Password);
		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("Clickonexplogin");
		Thread.sleep(3000);
		QaRobot.mouseHover("//a[@id='HeaderTop_aExpenseMngt']", "//span[@id='HeaderTop_lbltripsheet']");
		Thread.sleep(3000);
		int pAS1 = Integer.parseInt(TripQty);
		for (int k = 1; k <= pAS1; k++) {
			String[] tN1 = TripName.split(",");
			String b1 = tN1[k - 1];
			QaRobot.PassValue1("EXSearchTripName", b1);
			QaRobot.ClickOnElement("EXFilter");
			Thread.sleep(5000);
//			QaRobot.ClickOnElement("EXDeleteSheet");
		}
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close(); 
	}
}
