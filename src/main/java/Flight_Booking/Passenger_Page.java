package Flight_Booking;

import utilities.QaExtentReport;
import utilities.QaRobot;

public class Passenger_Page {

	public static void flightPassengerPage(String TripType, String ChooseOption) throws Exception {

		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Cart");
		Thread.sleep(8000);
		switch (TripType) {
		case "OneWay":
			QaRobot.ClickOnElement("ContinueToPassenger1");
			break;
		case "RoundTrip":
			QaRobot.ClickOnElement("ContinueToPassenger2");
			break;
		}
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Passenger page");
		Thread.sleep(5000);
		switch (ChooseOption) {
		case "SelectExtras":
			QaRobot.ClickOnElement("SelectExtras");
			break;
		case "SkipToPayment":
			QaRobot.ClickOnElement("SkipToPayment");
			break;
		}
		Thread.sleep(5000);
	}
}
