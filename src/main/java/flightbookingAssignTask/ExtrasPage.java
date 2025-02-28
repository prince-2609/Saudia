package flightbookingAssignTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class ExtrasPage {

	public static void SelectExtras(String TripType ,String NoExtra, String SelectExtras, String SeatNo,String ReturnSeatNumber,String DepartureSeat2
			,String DepartureSeat3,
String Baggageradiobutton) throws Throwable {

		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Extra page");

		String SeatRowNumber = SeatNo.split(" ")[0];// 34
		int row = Integer.parseInt(SeatRowNumber);
		String SeatNumber = SeatNo.split(" ")[1];// C

		int noOfExtra = Integer.parseInt(NoExtra);
		
		int BagRadio =Integer.parseInt(Baggageradiobutton);
		

		for (int i = 1; i <= noOfExtra; i++) {
			String[] Extra = SelectExtras.split(",");
			String a = Extra[i - 1];
			switch (a) {
			case "Seat":
				QaBrowser.driver.findElement(By.xpath("//a[contains(text(),'Select')]")).click();
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("Seat Page");
				int count = 0;

				for (int j = 30; j <= row; j++) {
					count++;// 1/2/3/4/5
					if (j == row) {
						WebElement SeatC = QaBrowser.driver
								.findElement(By.xpath("(//p[text()='" + SeatNumber + "'])[" + count + "]"));
						JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
						js3.executeScript("arguments[0].click()", SeatC);
						Thread.sleep(5000);
						break;
					}
				}
				QaExtentReport.extentScreenshot("Selected Seat");
				QaRobot.clickOnDisableElement("DeparterSeatConfirmButton");
//				QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']")).click();
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("SeatPage");

				//QaBrowser.driver.findElement(By.xpath("//span[@class='mdc-button__label']")).click();
				
				if(TripType.equalsIgnoreCase("RoundTrip")) {
					Thread.sleep(2000);
					QaRobot.clickOnDisableElement("NextFlight");
					//QaBrowser.driver.findElement(By.xpath("//span[@class='mdc-button__label']")).click();	
					Thread.sleep(2000);
					String seatRowNumber= ReturnSeatNumber.split(" ")[0];
					int row1 = Integer.parseInt(seatRowNumber);
					String SeatNumber1 = SeatNo.split(" ")[1];// C
					int count1 = 0;

					for (int k = 30; k <= row1; k++) {
						count1++;// 1/2/3/4/5
						if (k == row1) {
							WebElement SeatC = QaBrowser.driver
									.findElement(By.xpath("(//p[text()='" + SeatNumber1 + "'])[" + count1 + "]"));
							JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
							js4.executeScript("arguments[0].click()", SeatC);
							Thread.sleep(5000);
							break;
						}
					}
						QaExtentReport.extentScreenshot("Selected Seat for return trip");
						
						QaRobot.clickOnDisableElement("ReturnFlightConfirmButton");
						
					
						Thread.sleep(5000);
						QaExtentReport.extentScreenshot("SeatPage");
						
					
							
				
				
					QaRobot.clickOnDisableElement("FinalConfirmButton");
					Thread.sleep(8000);
				
				
				
				} 
				if(TripType.equalsIgnoreCase("MultiCity")) {
					Thread.sleep(2000);
					QaRobot.clickOnDisableElement("NextFlight");
					Thread.sleep(2000);
					
					String seatRowNumber2= DepartureSeat2.split(" ")[0];//37 A
					int row2 = Integer.parseInt(seatRowNumber2);
					String SeatNumber2 = DepartureSeat2.split(" ")[1];// A
					int count2 = 0;
					for (int k = 30; k <= row2; k++) {
						count2++;// 1/2/3/4/5
						if (k == row2) {
							WebElement SeatC = QaBrowser.driver
									.findElement(By.xpath("(//p[text()='" + SeatNumber2 + "'])[" + count2 + "]"));
							JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
							js4.executeScript("arguments[0].click()", SeatC);
							Thread.sleep(5000);
							break;
						}
					}
					
					QaExtentReport.extentScreenshot("Selected Seat for 2nd Time departure");
					
					QaRobot.clickOnDisableElement("ReturnFlightConfirmButton");
					
				
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SeatPage");
					
					Thread.sleep(2000);
		
					QaRobot.clickOnDisableElement("NextFlight");
					Thread.sleep(2000);
					
					
					
					String seatRowNumber3= DepartureSeat3.split(" ")[0];//37 A
					int row3 = Integer.parseInt(seatRowNumber3);
					String SeatNumber3 = DepartureSeat3.split(" ")[1];// A
					int count3 = 0;
					for (int k = 30; k <= row2; k++) {
						count3++;// 1/2/3/4/5
						if (k == row3) {
							WebElement SeatC = QaBrowser.driver
									.findElement(By.xpath("(//p[text()='" + SeatNumber3 + "'])[" + count3 + "]"));
							JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
							js4.executeScript("arguments[0].click()", SeatC);
							Thread.sleep(5000);
							break;
						}
					}
					
					QaExtentReport.extentScreenshot("Selected Seat for 3nd Time departure");
					
					QaRobot.clickOnDisableElement("ReturnFlightConfirmButton");
					
				
					Thread.sleep(5000);
					QaExtentReport.extentScreenshot("SeatPage");
				}

				break;

			case "Baggage":
//				QaBrowser.driver.findElement(By.xpath("//span[@class='button-txt']//a[contains(text(),'Add')]"))
//						.click();
				
				QaRobot.ClickOnElement("AddBaggageButton");
				Thread.sleep(6000);
				QaBrowser.driver.findElement(By.xpath("//div[@class='ebag-desc ng-star-inserted' and contains(.,' "+BagRadio+" Bag ')]//mat-icon")).click();
				
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Baggage Page");
				
			//	QaRobot.ClickOnElement("UpgradeBaggageConfirmButton");
				
				
				
				
				Thread.sleep(2000);
				if (TripType.equalsIgnoreCase("RoundTrip")) {
					WebElement NextBaggage = QaBrowser.driver.findElement(By.xpath("//span[text()='Next Flight']"));
					JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
					js4.executeScript("arguments[0].click()", NextBaggage);
//					QaRobot.ClickOnElement("NextFlight");
					Thread.sleep(2000);
					QaBrowser.driver.findElement(By.xpath("//div[@class='ebag-desc ng-star-inserted' and contains(.,' "
							+ BagRadio + " Bag ')]//mat-icon")).click();
					Thread.sleep(3000);
					QaExtentReport.extentScreenshot("Baggage Page");
					Thread.sleep(2000);
				}
				QaBrowser.driver.findElement(By.xpath("//button[@class='button--primary-large step-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base ng-star-inserted']")).click();
//				QaRobot.ClickOnElement("BaggageC");
				Thread.sleep(8000);

				break;
			case "FastTrack":
				QaBrowser.driver.findElement(By.xpath("//div[@class='service-btn']/span//a[contains(text(),'Add')]"))
						.click();
				
				Thread.sleep(5000);
				QaRobot.ClickOnElement("FastrackAddInternalButton");
				Thread.sleep(1000);
				QaExtentReport.extentScreenshot("fasttrack priority page");
				
				
				QaRobot.ClickOnElement("FastrackConfirmButton");
				

				break;
			case "MeetAndGreet":
				

				QaRobot.clickOnDisableElement("meet");
				Thread.sleep(5000);
				
				
				
				QaBrowser.driver.findElement(By.xpath("//span[text()='Select']")).click();
				Thread.sleep(2000);

				QaExtentReport.extentScreenshot("meet and greet page");
				Thread.sleep(2000);
				
				
				QaBrowser.driver.findElement(By.xpath("//span[text()='Confirm']")).click();
				
				
				QaBrowser.driver.findElement(By.xpath("(//span[text()=' Confirm'])")).click();

				break;

			}

		}
		QaRobot.clickOnDisableElement("ProccedToPayment");
		//QaBrowser.driver.findElement(By.xpath("//span[text()='Proceed to payment '] ")).click();
Thread.sleep(20000);
	}
}
