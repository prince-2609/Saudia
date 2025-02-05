package Flight_Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class Extra_Page {

	public static void flightExtrasPage(String NoExtras, String SelectExtras, String Seat) throws Exception {
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Extra page");
		int E = Integer.parseInt(NoExtras);
		for (int i = 1; i <= E; i++) {
			String[] tN = SelectExtras.split(",");
			String b = tN[i - 1];

			if (b.equalsIgnoreCase("Seat")) {
				QaRobot.ClickOnElement("SelectSeat");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Seat Page");
				WebElement Seat1 = QaBrowser.driver.findElement(By.xpath(
						"(//mat-tab-body[@id='mat-tab-content-1-0']/div/div/div/div/div[2]/table/tbody/tr/td/div/button)["
								+ Seat + "]"));
				JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
				js2.executeScript("arguments[0].click()", Seat1);
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Selected Seat");
				QaRobot.ClickOnElement("SeatC");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Seat Page");
				QaRobot.ClickOnElement("SeatConfirm");

			} else if (b.equalsIgnoreCase("Baggage")) {

			} else if (b.equalsIgnoreCase("FastTrack")) {

			} else if (b.equalsIgnoreCase("MeetAndGreet")) {

			}
		}
		Thread.sleep(8000);
		QaRobot.ClickOnElement("SkipToPayment1");

	}
}
