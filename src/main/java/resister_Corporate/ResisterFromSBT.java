package resister_Corporate;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class ResisterFromSBT {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CorporateRegistration", "Sheet4");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TCType, String TestScenario, String ccode, String URL,
			String CompanyName, String NOBusiness, String NOEmp, String RegId, String ContryCode, String CountryName,
			String CityCode, String CityName, String HOAddress, String CompanyURL, String AnnualBudget,
			String TravellerName, String JobTitle, String BEmail, String PCode, String Phonenumber) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + " - " + TCType + " - " + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		QaRobot.PassValue("SCompanyName", CompanyName);
		QaRobot.PassValue("SNatureOfBusiness", NOBusiness);
		QaRobot.PassValue("SNoOFEmp", NOEmp);
		QaRobot.PassValue("SRegId", RegId);
		TestBase.listofautosuggestion(By.xpath("/html/body/div/div/div/div/mat-optgroup[1]/mat-option/span"),
				ContryCode, CountryName, By.xpath("//input[@id='mat-input-4']"));
//		TestBase.listofautosuggestion(By.xpath("/html/body/div/div/div/div/mat-option/span"), CityCode, CityName,
//				By.xpath("//input[@id='mat-input-5']"));
		QaRobot.PassValue("SHeadOfficeAddress", HOAddress);
//		QaRobot.PassValue("SCompanyURL", CompanyURL);
		QaRobot.PassValue("SAnnualBudget", AnnualBudget);
		TestBase.listofautosuggestion(By.xpath("/html/body/div/div/div/div/mat-option/span"), CityCode, CityName,
				By.xpath("//input[@id='mat-input-5']"));
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Corporate information");
		QaRobot.ClickOnElement("ContinueToTravelAddministrator");
		Thread.sleep(2000);
		String EmployeeName[] = TravellerName.split(" ");
		String FNTitle = EmployeeName[0];
		String FN = EmployeeName[1];
		String LN = EmployeeName[2];
//		QaRobot.selectTextByLocator("//select[@id='tittle']", FNTitle);
		TestBase.listofTitle(By.xpath("/html/body/div[1]/div[2]/div/div/mat-option/span"), FNTitle,
				By.xpath("//div[@id='mat-select-value-1']/span"));
		QaRobot.PassValue("STravelexpFN", FN);
		QaRobot.PassValue("STravelexpLN", LN);
		QaRobot.PassValue("SJobTitle", JobTitle);
		QaRobot.PassValue("SBusinessEmail", BEmail);
		TestBase.listofautosuggestion(By.xpath("/html/body/div[1]/div/div/div/mat-optgroup/mat-option/span"),
				ContryCode, PCode, By.xpath("//input[@id='mat-input-13']"));
		QaRobot.PassValue("Sphoneno", Phonenumber);
		QaRobot.ClickOnElement("SCheckBox1");
		QaRobot.ClickOnElement("SCheckBox2");
		QaRobot.ClickOnElement("SCheckBox3");
		QaExtentReport.extentScreenshot("Travel administrator information");
		QaRobot.ClickOnElement("STravelAdministratorJoin");
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
}
