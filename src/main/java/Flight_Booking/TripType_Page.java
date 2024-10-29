package Flight_Booking;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class TripType_Page {

	public static void flightTriptype(String TripType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String BookAs
//			String adult, String child, String infant, String MoreOptions, String Currency, String Class,
//			String PANumber, String PreferredAirlineSelect, String ShowDirectFlight, String MyDatesAreFlexible
	) throws Exception {
		String DateSelection[] = DepartureDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ReturnDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("OneWay");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");

			TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
					// mat-option[contains(@id,'mat-option')]/span/div/div[1]
					OriginCityCode, OriginLocation, By.xpath("//input[@id='fromLocationControl']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
					DestinationCityCode, DestinationLocation, By.xpath("//input[@id='toLocationControl']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);

			QaBrowser.driver
					.findElement(By.xpath(
							"//div[@class='mat-mdc-form-field-icon-suffix ng-tns-c1205077789-21 ng-star-inserted']"))
					.click();
			Thread.sleep(3000);

			selectDateInCalendarOneWay(expDate, month, year);
			WebElement CalContinue = QaBrowser.driver
					.findElement(By.xpath("(//span[@class='mat-mdc-button-persistent-ripple mdc-button__ripple'])[3]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", CalContinue);
		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			QaRobot.ClickOnElement("RoundTrip");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");

			TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
					OriginCityCode, OriginLocation, By.xpath("//input[@id='fromLocationControl']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//mat-option[contains(@id,'mat-option')]/span/div/div[1]"),
					DestinationCityCode, DestinationLocation, By.xpath("//input[@id='toLocationControl']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);

			QaBrowser.driver
					.findElement(By.xpath(
							"//div[@class='mat-mdc-form-field-icon-suffix ng-tns-c1205077789-21 ng-star-inserted']"))
					.click();
			Thread.sleep(3000);

			selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
			WebElement CalContinue = QaBrowser.driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[4]/div[2]/button/span[4]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", CalContinue);
		} else if (TripType.equalsIgnoreCase("MultiCity")) {

		}

		if (BookAs != "Employee") {
			QaRobot.ClickOnElement("BookAs");
			switch (BookAs) {
			case "Guest":
				QaRobot.ClickOnElement("Guest");
				break;
			case "MultiPassenger":
				QaRobot.ClickOnElement("MultiPassenger");
				break;
			}
			QaRobot.ClickOnElement("BookAsConfirm");
		}
		if (BookAs.equalsIgnoreCase("Employee")) {
			QaRobot.ClickOnElement("EmpDetails1");
			QaRobot.ClickOnElement("SelectEmpDetails");
			Thread.sleep(3000);
		}
		QaRobot.ClickOnElement("PolDetails");
		QaRobot.ClickOnElement("SelectPolDetails");
		Thread.sleep(3000);

//			QaRobot.ClickOnElement("AjTravellers");
////			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Travellers</i></b>");
//
//			QaRobot.selectValueFromDropdown("AjAdult", adult, "<b><i>Select adult for booking</i></b>" + " - " + adult);
//			Thread.sleep(2000);
//
//			QaRobot.selectValueFromDropdown("AjChild", child, "<b><i>Select child for booking</i></b>" + " - " + child);
//			Thread.sleep(2000);
//
//			QaRobot.selectValueFromDropdown("AjInfant", infant,
//					"<b><i>Select infant for booking</i></b>" + " - " + infant);
//			Thread.sleep(2000);
//
//			QaRobot.ClickOnElement("AjTravellers");
//
//			if (MoreOptions.equalsIgnoreCase("Yes")) {
////				QaRobot.ClickOnElement("MoreOptionsF");
////				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
////				Thread.sleep(2000);
//
//				QaRobot.selectValueFromDropdown("AjCurrencyF", Currency, "<b><i>Select Currency for booking</i></b>");
//				Thread.sleep(2000);
//
//				QaRobot.selectTextByLocator("//select[@id='ddl_class']", Class,
//						"<b><i>Select Class for booking</i></b>");
//				Thread.sleep(2000);
//
////				QaRobot.ClickOnElement("PreferredAirline");
////				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on PreferredAirline</i></b>");
////				Thread.sleep(2000);
////
////				int pAS = Integer.parseInt(PANumber);
////				for (int i = 1; i <= pAS; i++) {
////					String[] tN = PreferredAirlineSelect.split(",");
////					String b = tN[i - 1];
////					TestBase.listofautosuggestion1(
////							By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']/li"), b,
////							By.xpath("//input[@placeholder='Search Airline']"));
////				}
//
//				if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
//					QaRobot.ClickOnElement("ShowDirectFlightF");
////					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
//				}
//
//				if (MyDatesAreFlexible.equalsIgnoreCase("Yes")) {
//					QaRobot.ClickOnElement("MyDatesAreFlexibleF");
////					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MyDatesAreFlexible</i></b>");
//				}
//			}

		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("SearchFlight");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
//			QaRobot.ScreenshotMethod("FlightTrip", "<b><i>Screenshot for Flight Trip</i></b>");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year) throws ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);
//		QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightDepartureDate']")).clear();

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new ExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new ExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}
		String monthYear = QaBrowser.driver.findElement(By.xpath("//span[@class='month']")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new ExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				WebElement Next = QaBrowser.driver.findElement(
						By.xpath("(//span[@class='mat-mdc-button-persistent-ripple mdc-fab__ripple'])[2]"));
				JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
				js2.executeScript("arguments[0].click()", Next);
//				QaBrowser.driver
//						.findElement(By.xpath("(//span[@class='mat-mdc-button-persistent-ripple mdc-fab__ripple'])[2]"))
//						.click();
				monthYear = QaBrowser.driver.findElement(By.xpath("//span[@class='month']")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
					"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-one-way-calendar/div/div/div[3]/table/tbody/tr/td"));
			for (WebElement ele : allDates) {
				String dt = ele.getText();
				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
		}
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}
		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "/" + Month + "/" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
//			throw new B2cExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span"))
				.getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
//			throw new B2cExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath(
						"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/button[2]/span[4]"))
						.click();
				monthYear = QaBrowser.driver.findElement(By.xpath(
						"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span"))
						.getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}

			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
					"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[3]/table[1]/tbody/tr/td/div/span[2]"));
			for (WebElement ele : allDates) {
				String dt = ele.getText();
				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath(
					"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span"))
					.getText();
			Thread.sleep(3000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(3000);
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath(
							"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/button[2]/span[4]"))
							.click();
					monthYear1 = QaBrowser.driver.findElement(By.xpath(
							"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[2]/span"))
							.getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/app-root/app-layout/div/app-dasboard-tab-layout/div/div/div/app-booking-tab-layout/div/form/div/div/section/div/div[2]/div[1]/app-round-trip-calendar/div/div/div[3]/table[1]/tbody/tr/td/div/span[2]"));
				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();
					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}

}
