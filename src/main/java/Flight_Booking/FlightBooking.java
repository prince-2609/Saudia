package Flight_Booking;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class FlightBooking {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("FlightBooking", "Sheet6");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TestScenario, String ccode, String URL,
			String EmployeName, String TravelerType, String uname, String pwd, String TripType, String MarketType,
			String OriginCityCode, String OriginLocation, String DestinationCityCode, String DestinationLocation,
			String DepartureDate, String ReturnDate, String BookAs, String FareType, String SFlight, String GFare,
			String BFare, String FareTypeR, String SFlightR, String GFareR, String BFareR) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		QaRobot.ClickOnElement("SaudiyaLogInTab");
		Thread.sleep(3000);
		QaRobot.PassValue("EmailAdd", uname);
		QaRobot.PassValue("Password", pwd);
		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ClickOnlogin");
		Thread.sleep(3000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);

		TripType_Page.flightTriptype(TripType, OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation,
				DepartureDate, ReturnDate, BookAs);
		Result_Page.ResultPageForFlight(TripType, FareType, SFlight, GFare, BFare, FareTypeR, SFlightR, GFareR, BFareR);
		Checkout_Page.flightCheckoutPage(TripType, OriginCityCode, OriginLocation, DestinationCityCode,
				DestinationLocation, DepartureDate, ReturnDate, BookAs);

	}

	@AfterTest
	public static void After_Test() {
//		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
}
