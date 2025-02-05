package Flight_Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class Payment_Page {

	public static void flightPaymentPage(String PaymentMethod,String CardNumber,String NameOfCardHolder,String CVV) throws Exception {
		Thread.sleep(15000);
		QaExtentReport.extentScreenshot("Payment page");
//		QaRobot.scrollPage(3000);
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("Payment Method");

		if (PaymentMethod.equalsIgnoreCase("SavedCards")) {
			
		} else if (PaymentMethod.equalsIgnoreCase("UseDifferentCard")) {
			QaRobot.ClickOnElement("UseDifferentCard");
			QaRobot.PassValue("CardNumber", CardNumber);
			QaRobot.ClickOnElement("SelectMonth");
			QaRobot.ClickOnElement("SelectMonthNo");
			QaRobot.ClickOnElement("SelectYear");
			QaRobot.ClickOnElement("SelectYearNo");
			QaRobot.PassValue("NameOfCardHolder", NameOfCardHolder);
			QaRobot.PassValue("CVV", CVV);

		} else if (PaymentMethod.equalsIgnoreCase("SADAD")) {

		}
		QaRobot.ClickOnElement("TearmCheck");
		QaRobot.ClickOnElement("PayNow");
		Thread.sleep(15000);
		WebElement OTP = QaBrowser.driver.findElement(By.xpath("//iframe[@id='Cardinal-CCA-IFrame']"));
		QaBrowser.driver.switchTo().frame(OTP);
		QaRobot.PassValue("OPT", "1234");
		QaRobot.ClickOnElement("Submit");
		Thread.sleep(20000);
	}
}
