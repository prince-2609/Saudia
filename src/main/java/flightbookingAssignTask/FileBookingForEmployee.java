package flightbookingAssignTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class FileBookingForEmployee {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("SaudiaLogin1", "Sheet9");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TestScenario, String ccode, String URL,
			String EmployeName, String TravelerType, String uname, String pwd, String TripType, String MarketType,
			String OriginCityCode, String OriginCityCode2, String OriginCityCode3, String OriginLocation,
			String OriginLocation2, String OriginLocation3, String DestinationCityCode, String DestinationCityCode2,
			String DestinationCityCode3, String DestinationLocation, String DestinationLocation2,
			String DestinationLocation3, String DepartureDate, String DepartureDate2, String DepartureDate3,
			String ReturnDate, String BookAs, String PromoCode, String FareType, String SelectFlight,
			String SelectFlightMulticity, String SubfareType, String BusinessFareType, String FareTypeR,
			String SFlightR, String GFareR, String BFareR, String SelectOption, String NoExtra, String SelectExtras,
			String SeatNo, String ReturnSeatNumber, String DepartureSeat2, String DepartureSeat3,
			String Baggageradiobutton, String PaymentMethod, String CardNumber, String NameOfCardHolder, String CVV)
			throws Throwable {

		// this line is used to create test inside extent report
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		QaRobot.clickOnDisableElement("SaudiyaLogInTab1");
		// QaRobot.ClickOnElement("SaudiyaLogInTab1");
		QaRobot.PassValue("emailAddress", uname);
		QaRobot.PassValue("password1", pwd);

		Thread.sleep(2000);

		WebElement capchaFrame = QaBrowser.driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));

		QaBrowser.driver.switchTo().frame(capchaFrame);

		QaRobot.ClickOnElement("FrameCheckbox");
		Thread.sleep(30000);

		QaBrowser.driver.switchTo().defaultContent();

		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(5000);

		QaRobot.clickOnDisableElement("clickOnLOgin1");
		// QaRobot.ClickOnElement("clickOnLOgin1");

		Thread.sleep(3000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);

		TripTypeSearchPage.flightTriptype(TripType, OriginCityCode, OriginCityCode2, OriginCityCode3, OriginLocation,
				OriginLocation2, OriginLocation3, DestinationCityCode, DestinationCityCode2, DestinationCityCode3,
				DestinationLocation, DestinationLocation2, DestinationLocation3, DepartureDate, DepartureDate2,
				DepartureDate3, ReturnDate, BookAs);
		ResultPage.resultPageForFlight(TripType, FareType, SelectFlight, SelectFlightMulticity, SubfareType,
				BusinessFareType, FareTypeR, SFlightR, GFareR, BFareR);
		PassengerPage.flightPassengerPage(TripType, SelectOption);
		ExtrasPage.SelectExtras(TripType, NoExtra, SelectExtras, SeatNo, ReturnSeatNumber, DepartureSeat2,
				DepartureSeat3, Baggageradiobutton);
		// PaymentPage.paymentPage(TripType,PaymentMethod, CardNumber, NameOfCardHolder,
		// CVV);

	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

}