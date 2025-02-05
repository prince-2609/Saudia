package Flight_Booking;

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
public class FlightBooking {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("FlightBooking", "Sheet8");
	}

	@Test(dataProvider = "getexceldata")
	public static void flightBooking(String TestCaseId, String TestScenario, String ccode, String URL,
			String EmployeName, String TravelerType, String uname, String pwd, String TripType, String MarketType,
			String OriginCityCode, String OriginLocation, String DestinationCityCode, String DestinationLocation,
			String DepartureDate, String ReturnDate, String BookAs, String PromoCode, String FareType, String SFlight,
			String GFare, String BFare, String FareTypeR, String SFlightR, String GFareR, String BFareR,
			String ModifySearch, String ChangeTrip, String TripTypeM, String MarketTypeM, String OriginCityCodeM,
			String OriginLocationM, String DestinationCityCodeM, String DestinationLocationM, String ChangeTripDate,
			String DepartureDateM, String ReturnDateM, String ChangeTravellers, String adultM, String childM,
			String infantM, String ChangeClass, String ClassM, String ChooseOption, String NoExtras,
			String SelectExtras, String Seat, String PaymentMethod, String CardNumber, String NameOfCardHolder,
			String CVV) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		QaRobot.ClickOnElement("SaudiyaLogInTab");
		Thread.sleep(3000);
		QaRobot.PassValue("EmailAdd", uname);
		QaRobot.PassValue("Password", pwd);
		Thread.sleep(3000);
		WebElement Capcha = QaBrowser.driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
		QaBrowser.driver.switchTo().frame(Capcha);
		QaRobot.ClickOnElement("Capcha1");
		Thread.sleep(20000);
		QaBrowser.driver.switchTo().defaultContent();
		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ClickOnlogin");
		Thread.sleep(3000);
		QaExtentReport.test.log(Status.INFO, "<b><i>Employee Name is  </i></b>" + EmployeName);
		QaExtentReport.test.log(Status.INFO, "<b><i> Traveler Type is  </i></b>" + TravelerType);

		TripType_Page.flightTriptype(TripType, OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation,
				DepartureDate, ReturnDate, BookAs, PromoCode);
		Result_Page.ResultPageForFlight(TripType, FareType, SFlight, GFare, BFare, FareTypeR, SFlightR, GFareR, BFareR,
				ModifySearch, ChangeTrip, TripTypeM, MarketTypeM, OriginCityCodeM, OriginLocationM,
				DestinationCityCodeM, DestinationLocationM, ChangeTripDate, DepartureDateM, ReturnDateM,
				ChangeTravellers, adultM, childM, infantM, ChangeClass, ClassM);
		Passenger_Page.flightPassengerPage(TripType, ChooseOption);
		Extra_Page.flightExtrasPage(NoExtras, SelectExtras, Seat);
		Payment_Page.flightPaymentPage(PaymentMethod, CardNumber, NameOfCardHolder, CVV);

	}

	@AfterTest
	public static void After_Test() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}
}
