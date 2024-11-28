package Flight_Booking;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class Result_Page {

	public static void ResultPageForFlight(String TripType, String FareType, String SFlight, String GFare, String BFare,
			String FareTypeR, String SFlightR, String GFareR, String BFareR
//			String ModifySearch, String ChangeTrip, String TripTypeM,
//			String MarketTypeM, String OriginCityCodeM, String OriginLocationM, String DestinationCityCodeM,
//			String DestinationLocationM, String ChangeTripDate, String DepartureDateM, String ReturnDateM,
//			String ChangeTravellers, String adultM, String childM, String infantM, String ChangeClass, String ClassM,
//			String ShowDirectFlightM, String AdvanceOptions, String CurrencyM, String PANumberM,
//			String PreferredAirlineSelectM, String Applyfilter, String FareType, String AirLine, String Trip
	) throws Exception {
		Thread.sleep(10000);

//		String url = QaBrowser.driver.getCurrentUrl();
//		String[] uid = url.split("=");
//		System.out.println(url);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);

//		String DateSelection[] = DepartureDateM.split("-");
//		String year = DateSelection[2];
//		String month = DateSelection[1];
//		String expDate = DateSelection[0];
//		String DateSelection1[] = ReturnDateM.split("-");
//		String year1 = DateSelection1[2];
//		String month1 = DateSelection1[1];
//		String expDate1 = DateSelection1[0];
//
//		if (ModifySearch.equalsIgnoreCase("Yes")) {
//			QaRobot.ClickOnElement("AjModifySearchF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");
//
//			if (ChangeTrip.equalsIgnoreCase("Yes")) {
//				if (TripTypeM.equalsIgnoreCase("OneWay")) {
//					QaRobot.ClickOnElement("OneWayMF");
//
//					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), OriginCityCodeM,
//							OriginLocationM, By.xpath("//input[@id='MtxtDepartureCity0']"));
//					QaExtentReport.test.log(Status.INFO,
//							"<b><i>Modified Departure city : </i></b>" + OriginCityCodeM + " - " + OriginLocationM);
//					Thread.sleep(2000);
//
//					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DestinationCityCodeM,
//							DestinationLocationM, By.xpath("//input[@id='MtxtDestinationCity0']"));
//					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>" + DestinationCityCodeM
//							+ " - " + DestinationLocationM);
//					Thread.sleep(2000);
//				} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
//					QaRobot.ClickOnElement("RoundTripMF");
//
//					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), OriginCityCodeM,
//							OriginLocationM, By.xpath("//input[@id='MtxtDepartureCity0']"));
//					QaExtentReport.test.log(Status.INFO,
//							"<b><i>Modified Departure city : </i></b>" + OriginCityCodeM + " - " + OriginLocationM);
//					Thread.sleep(2000);
//
//					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DestinationCityCodeM,
//							DestinationLocationM, By.xpath("//input[@id='MtxtDestinationCity0']"));
//					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>" + DestinationCityCodeM
//							+ " - " + DestinationLocationM);
//					Thread.sleep(2000);
//				} else if (TripTypeM.equalsIgnoreCase("MultiCity")) {
//
//				}
//			}
//
//			if (ChangeTripDate.equalsIgnoreCase("Yes")) {
//				if (TripTypeM.equalsIgnoreCase("OneWay")) {
//					QaRobot.ClickOnElement("OneWayMF");
//					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified OneWay</i></b>");
//
//					QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[1]")).click();
//					Thread.sleep(2000);
//
//					selectDateInCalendarOneWay(expDate, month, year);
//				} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
//					QaRobot.ClickOnElement("RoundTripMF");
//					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified RoundTrip</i></b>");
//
//					QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[1]")).click();
//					Thread.sleep(2000);
//
//					selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
//				} else if (TripTypeM.equalsIgnoreCase("MultiCity")) {
//
//				}
//			}
//
//			if (ChangeTravellers.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("ChangeTravellersF");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Travellers</i></b>");
//
//				QaRobot.selectValueFromDropdown("v12AdultMF", adultM,
//						"<b><i>Select Modified adult for booking</i></b>" + " - " + adultM);
//				Thread.sleep(2000);
//
//				QaRobot.selectValueFromDropdown("v12ChildMF", childM,
//						"<b><i>Select Modified child for booking</i></b>" + " - " + childM);
//				Thread.sleep(2000);
//
//				QaRobot.selectValueFromDropdown("v12InfantMF", infantM,
//						"<b><i>Select Modified infant for booking</i></b>" + " - " + infantM);
//				Thread.sleep(2000);
//
//				QaRobot.ClickOnElement("ChangeTravellersF");
//			}
//
//			if (ChangeClass.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("ChangeTravellersF");
//
//				QaRobot.selectTextByLocator("//select[@id='ddlClass']", ClassM,
//						"<b><i>Select Modified Class for booking</i></b>");
//				Thread.sleep(2000);
//
//				QaRobot.ClickOnElement("ChangeTravellersF");
//			}
//
//			if (ShowDirectFlightM.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("ShowDirectFlightMF");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Show Direct Flight</i></b>");
//			}
//
//			if (AdvanceOptions.equalsIgnoreCase("Yes")) {
//				QaRobot.ClickOnElement("AdvanceOptionMF");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified AdvanceOption</i></b>");
//
//				QaRobot.selectValueFromDropdown("CurrencyMF", CurrencyM,
//						"<b><i>Select Modified Currency for booking</i></b>");
//				Thread.sleep(2000);
//
////			QaRobot.ClickOnElement("PreferredAirlineMF");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified PreferredAirline</i></b>");
////			Thread.sleep(2000);
////
////			int pAS = Integer.parseInt(PANumberM);
////			for (int i = 1; i <= pAS; i++) {
////				String[] tN = PreferredAirlineSelectM.split(",");
////				String b = tN[i - 1];
////				TestBase.listofautosuggestion1(By.xpath("//ul[@class='dropdown-menu-form  dropdown-menu']/li"), b,
////						By.xpath("//input[@placeholder='Search']"));
////			}
////
////			QaRobot.ClickOnElement("PreferredAirlineMF");
//			}
//
//			QaRobot.ClickOnElement("ModifySearchMF");
////		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
//			Thread.sleep(10000);
//		}
//
//		if (Applyfilter.equalsIgnoreCase("Yes")) {
//			if (FareType.equalsIgnoreCase("All")) {
//				QaRobot.ClickOnElement("Refundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
//				Thread.sleep(3000);
//
//				QaRobot.ClickOnElement("NonRefundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
//				Thread.sleep(3000);
//			} else if (FareType.equalsIgnoreCase("Refundable")) {
//				QaRobot.ClickOnElement("Refundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
//				Thread.sleep(3000);
//			} else if (FareType.equalsIgnoreCase("Non-Refundable")) {
//				QaRobot.ClickOnElement("NonRefundable");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
//				Thread.sleep(3000);
//			}
//			List<WebElement> listOfAirLine = QaBrowser.driver
//					.findElements(By.xpath("(//div[@id='tdContainerTblAirlines'])[2]//li//span"));
//			for (WebElement autoAirline : listOfAirLine) {
//				if (autoAirline.getText().equalsIgnoreCase(AirLine)) {
//					autoAirline.click();
//					break;
//				}
//			}
//		}
		QaExtentReport.extentScreenshot("Result Page");

//		if (TripType.equalsIgnoreCase("OneWay")) {
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
		mo.executeScript("window.scrollBy(0,400)", "");
		QaRobot.ClickOnElement("FlightDetails");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Flight Details");
		QaRobot.ClickOnElement("FlightDetailsClose");
		Thread.sleep(3000);
		if (FareType.equalsIgnoreCase("Guest")) {
			QaBrowser.driver.findElement(By.xpath(
					"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[3]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[1]/div[2]/div[2]/div[2]/button)["
							+ SFlight + "]"))
					.click();
			Thread.sleep(5000);
			switch (GFare) {
			case "Saver":
				QaBrowser.driver.findElement(By.xpath(
						"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[1]"))
						.click();
				break;
			case "Basic":
				QaBrowser.driver.findElement(By.xpath(
						"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[2]"))
						.click();
				break;
			case "Semi Flex":
				QaBrowser.driver.findElement(By.xpath(
						"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
						.click();
				break;
			case "Flex":
				QaBrowser.driver.findElement(By.xpath(
						"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[4]"))
						.click();
				break;
			}
		} else if (FareType.equalsIgnoreCase("Business")) {
			QaBrowser.driver.findElement(By.xpath(
					"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[3]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[2]/div[2]/div[2]/div[2]/button)["
							+ SFlight + "]"))
					.click();
			Thread.sleep(5000);
			switch (BFare) {
			case "Basic":
				QaBrowser.driver.findElement(By.xpath(
						"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[1]"))
						.click();
				break;
			case "Semi Flex":
				QaBrowser.driver.findElement(By.xpath(
						"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[2]"))
						.click();
				break;
			case "Flex":
				QaBrowser.driver.findElement(By.xpath(
						"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
						.click();
				break;
			}
		}
		if (TripType.equalsIgnoreCase("RoundTrip")) {
			Thread.sleep(3000);
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(3000);
			QaRobot.ClickOnElement("FlightDetailsR");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Flight Details");
			QaRobot.ClickOnElement("FlightDetailsClose");
			Thread.sleep(3000);
			if (FareTypeR.equalsIgnoreCase("Guest")) {
				QaBrowser.driver.findElement(By.xpath(
						"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[4]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[1]/div[2]/div[2]/div[2]/button[1])["
								+ SFlightR + "]"))
						.click();
				Thread.sleep(5000);
				switch (GFareR) {
				case "Saver":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[1]"))
							.click();
					break;
				case "Basic":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[2]"))
							.click();
					break;
				case "Semi Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
							.click();
					break;
				case "Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[4]"))
							.click();
					break;
				}
			} else if (FareTypeR.equalsIgnoreCase("Business")) {
				QaBrowser.driver.findElement(By.xpath(
						"(/html/body/app-root/app-layout/div/app-flight-tab-layout/div/div[4]/app-flight-record/mat-card/div/div[2]/app-flight-cabin-selection/div/div[2]/div[2]/div[2]/div[2]/button)["
								+ SFlightR + "]"))
						.click();
				Thread.sleep(5000);
				switch (BFareR) {
				case "Basic":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[1]"))
							.click();
					break;
				case "Semi Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[2]"))
							.click();
					break;
				case "Flex":
					QaBrowser.driver.findElement(By.xpath(
							"(//button[@class='button--primary-small select-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base'])[3]"))
							.click();
					break;
				}
			}
		}
	}
}
