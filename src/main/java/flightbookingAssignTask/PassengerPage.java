package flightbookingAssignTask;

import org.openqa.selenium.By;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class PassengerPage {
public static void flightPassengerPage(String Triptype, String SelectOption) throws Throwable {

	Thread.sleep(10000);
	
	QaExtentReport.extentScreenshot("Passenger page");
	
	Thread.sleep(7000);
	
	switch (Triptype) {
	case "OneWay":
		
		if(SelectOption.equalsIgnoreCase("SkipToPayment")) {
			QaBrowser.driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[1]/span[2]")).click();
			
		}
		else if(SelectOption.equalsIgnoreCase("SelectExtras")) {
			QaBrowser.driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[2]/span[2]")).click();
		}
		break;
	case "RoundTrip":
		
		if(SelectOption.equalsIgnoreCase("SkipToPayment")) {
			QaBrowser.driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[1]/span[2]")).click();
			
		}
		else if(SelectOption.equalsIgnoreCase("SelectExtras")) {
			QaRobot.clickOnDisableElement("SelectExtras2");
			//QaBrowser.driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[2]/span[2]")).click();
		}
		break;
		
case "MultiCity":
		
		if(SelectOption.equalsIgnoreCase("SkipToPayment")) {
			QaBrowser.driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[1]/span[2]")).click();
			
		}
		else if(SelectOption.equalsIgnoreCase("SelectExtras")) {
			QaRobot.clickOnDisableElement("SelectExtras2");
			//QaBrowser.driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-passenger-tab-layout/section[1]/app-contactdetails/section/form/div[2]/div/button[2]/span[2]")).click();
		}
		break;
	
	}

}


}

