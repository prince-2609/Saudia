package expenseTravog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Base.TestBase;

import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class Expense {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("TravogExpense", "Travog");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TestScenario, String ccode, String URL, String LoginType,
			String Emailid, String Password, String TravellerName, String Phonenumber, String Workemail,
			String CompanyName, String Currency, String CountryCode, String citycode, String FcityName,
			String signPassword, String ConfirmPassword, String OTP) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaExtentReport.extentScreenshot("Dashboard");
		Thread.sleep(3000);
		if (LoginType.equalsIgnoreCase("Login")) {
			QaRobot.ClickOnElement("expenlogin");
			QaRobot.PassValue("loginemailexp", Emailid);
			QaRobot.PassValue("loginpasswordexp", Password);
			QaExtentReport.extentScreenshot("Login Page");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("Clickonexplogin");
		} else if (LoginType.equalsIgnoreCase("Register")) {
			QaRobot.ClickOnElement("expregister");
			String EmployeeName[] = TravellerName.split(" ");
			String FNTitle = EmployeeName[0];
			String FN = EmployeeName[1];
			String LN = EmployeeName[2];
			QaRobot.selectTextByLocator("//select[@id='tittle']", FNTitle);
			QaRobot.PassValue("TravelexpFN", FN);
			QaRobot.PassValue("TravelexpLN", LN);
			QaRobot.PassValue("expphoneno", Phonenumber);
			QaRobot.PassValue("expregisteremail", Workemail);
			QaRobot.PassValue("expcompanyname", CompanyName);
			QaRobot.selectTextByLocator("//select[@id='currency']", Currency);
			QaRobot.selectTextByLocator("//select[@id='country']", CountryCode);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), citycode, FcityName,
					By.xpath("//input[@id='txtHTCity']"));
			QaRobot.PassValue("expsignuppassword", signPassword);
			QaRobot.PassValue("expsignconfirmpass", ConfirmPassword);
			QaExtentReport.extentScreenshot("Register user detail.");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("expsubmitregis");
			Thread.sleep(5000);
			QaRobot.switchframe("//div[@id='recaptcha-container']/div/div/div/iframe");
			QaRobot.ClickOnElement("expcaptchacheck");
			Thread.sleep(8000);
			QaBrowser.driver.switchTo().alert().accept();
			Thread.sleep(5000);
			QaBrowser.driver.switchTo().parentFrame();
			QaRobot.PassValue("ExpOTP", OTP);
			QaExtentReport.extentScreenshot(" Phone No.OTP.");
			Thread.sleep(3000);
			QaRobot.ClickOnElement("expverifyOTP");
			Thread.sleep(5000);
			QaBrowser.driver.switchTo().alert().accept();
//			Thread.sleep(5000);
//			QaRobot.ClickOnElement("expregissuccess");
//			Thread.sleep(5000);
//			QaBrowser.driver.switchTo().parentFrame();
//		
			Thread.sleep(15000);
			QaExtentReport.extentScreenshot("Email OTP.");
			QaRobot.ClickOnElement("expregissuccess");
			Thread.sleep(2000);

			QaRobot.ClickOnElement("expnextsubmit");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Terms and conditions.");
			QaRobot.ClickOnElement("exptermandcond");
			Thread.sleep(10000);
			QaExtentReport.extentScreenshot("Successfully Registered.");
		}
	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
	}
}
