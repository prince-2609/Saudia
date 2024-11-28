package Flight_Booking;

import utilities.QaRobot;

public class Checkout_Page {

	public static void flightCheckoutPage(String TripType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String BookAs
//			String adult, String child, String infant, String MoreOptions, String Currency, String Class,
//			String PANumber, String PreferredAirlineSelect, String ShowDirectFlight, String MyDatesAreFlexible
	) throws Exception {
		Thread.sleep(5000);
		switch (TripType) {
		case "OneWay":
			QaRobot.ClickOnElement("ContinueToPassenger1");
			break;
		case "RoundTrip":
			QaRobot.ClickOnElement("ContinueToPassenger2");
			break;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
