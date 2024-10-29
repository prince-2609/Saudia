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

//		TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
//				OriginCityCode, OriginLocation, By.xpath("//input[@id='fromLocationControl']"));
//
//		TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
//				DestinationCityCode, DestinationLocation, By.xpath("//input[@id='toLocationControl']"));
//
//		QaBrowser.driver
//				.findElement(By
//						.xpath("//div[@class='mat-mdc-form-field-icon-suffix ng-tns-c1205077789-21 ng-star-inserted']"))
//				.click();
//		Thread.sleep(3000);
//
//		String DateSelection[] = DepartureDate.split("-");
//		String year = DateSelection[2];
//		String month = DateSelection[1];
//		String expDate = DateSelection[0];
//		String DateSelection1[] = ReturnDate.split("-");
//		String year1 = DateSelection1[2];
//		String month1 = DateSelection1[1];
//		String expDate1 = DateSelection1[0];
//		selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
//		WebElement CalContinue = QaBrowser.driver.findElement(By.xpath(
//				"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[4]/div[2]/button/span[4]"));
//		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//		js2.executeScript("arguments[0].click()", CalContinue);
//		if (BookAs != "Employee") {
//			QaRobot.ClickOnElement("BookAs");
//			switch (BookAs) {
//			case "Guest":
//				QaRobot.ClickOnElement("Guest");
//				break;
//			case "MultiPassenger":
//				QaRobot.ClickOnElement("MultiPassenger");
//				break;
//			}
//			QaRobot.ClickOnElement("BookAsConfirm");
//		}
//		QaExtentReport.extentScreenshot("Search Page");
//		QaRobot.ClickOnElement("SearchFlight");
	}

	@AfterTest
	public static void After_Test() {
//		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

}
