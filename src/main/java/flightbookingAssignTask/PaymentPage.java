package flightbookingAssignTask;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.bytebuddy.implementation.InvokeDynamic.WithImplicitArguments;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class PaymentPage {
	public static void paymentPage(String TripType,String PaymentMethod, String CardNumber, String NameOfCardHolder, String CVV)
			throws Throwable {

		Thread.sleep(25000);
		QaExtentReport.extentScreenshot("Payment page");

		switch (TripType) {
		case "OneWay":
			if (PaymentMethod.equalsIgnoreCase("UseDifferentCard")) {
				QaBrowser.driver
						.findElement(By.xpath(
								"//*[@id=\"mat-expansion-panel-header-24\"]/span/mat-panel-description/div/div/mat-icon"))
						.click();

				QaRobot.PassValue("cardNumber1", CardNumber);

				QaRobot.ClickOnElement("selectMonth1");
				QaRobot.ClickOnElement("selectMonthNumber");
				QaRobot.ClickOnElement("selectYear1");
				QaRobot.ClickOnElement("selectYearNumber");

				QaRobot.PassValue("NameOfCardholder", NameOfCardHolder);
				QaRobot.PassValue("cvv", CVV);

			}
			
			

			break;

		case "RoundTrip":
			
			
			if (PaymentMethod.equalsIgnoreCase("UseDifferentCard")) {
				QaBrowser.driver
						.findElement(By.xpath(
								"//*[@id=\"mat-expansion-panel-header-24\"]/span/mat-panel-description/div/div/mat-icon"))
						.click();

				QaRobot.PassValue("cardNumber1", CardNumber);

				QaRobot.ClickOnElement("SelectMonthForRoundtrip");
				QaRobot.ClickOnElement("selectMonthNumberRoundTrip");
				QaRobot.ClickOnElement("SelectYearForroundTrip");
				QaRobot.ClickOnElement("selectYearNumber");

				QaRobot.PassValue("NameOfCardholder", NameOfCardHolder);
				QaRobot.PassValue("cvv", CVV);

			}

			break;

		
		}

//		if (PaymentMethod.equalsIgnoreCase("UseDifferentCard")) {
//			QaBrowser.driver
//					.findElement(By.xpath(
//							"//*[@id=\"mat-expansion-panel-header-24\"]/span/mat-panel-description/div/div/mat-icon"))
//					.click();
//
//			QaRobot.PassValue("cardNumber1", CardNumber);
//
//			QaRobot.ClickOnElement("selectMonth1");
//			QaRobot.ClickOnElement("selectMonthNumber");
//			QaRobot.ClickOnElement("selectYear1");
//			QaRobot.ClickOnElement("selectYearNumber");
//
//			QaRobot.PassValue("NameOfCardholder", NameOfCardHolder);
//			QaRobot.PassValue("cvv", CVV);
//
//		}
		QaRobot.ClickOnElement("Tearmcheck");

		WebElement paynowButton = QaBrowser.driver.findElement(By.xpath("//span[text()='Pay Now']"));

		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
		js.executeScript("arguments[0].click()", paynowButton);
		Thread.sleep(30000);
		
		
		WebElement OTP = QaBrowser.driver.findElement(By.xpath("//iframe[@id='Cardinal-CCA-IFrame']"));
		QaBrowser.driver.switchTo().frame(OTP);
		QaRobot.PassValue("OPT", "1234");
		QaRobot.ClickOnElement("Submit");
		Thread.sleep(20000);

		// QaRobot.ClickOnElement("PayNOW");
	}

}
//mat-panel-description[@class='mat-expansion-panel-header-description ng-tns-c2690051721-94']/div/div/mat-icon
//mat-expansion-panel-header[@id='mat-expansion-panel-header-22']/span/mat-panel-description/div/div/mat-icon