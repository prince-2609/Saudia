package expenseTravog;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class Dashboard_ExpenseManagement {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Dashboard_ExpenseManagement", "Dashboard_TravogExpTripSheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void ExpenseManagement(String TestCaseId, String TestScenario, String ccode, String URL,
			String Emailid, String Password, String TripName, String Destination, String Destination_Name,
			String Start_Date, String End_Date, String TripType, String CostCenter, String PerDiemCurrency,
			String AdvanceCurrency, String Projectsheet, String PerDiemAmmount, String AdvanceAmount,
			String Description, String AddType, String Category, String Merchant, String ExpenseFromDate,
			String ExpenseToDate, String ExpenseCurrency, String ExpenseAmount, String GSTNumber, String ModeOfPayment,
			String ExpenceComment, String ConveyanceType, String Corigin, String COrigin_Name, String CDestination,
			String CDestination_Name, String ConveyanceFromDate, String ConveyanceToDate) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		TestBase.Companycode(ccode, URL);
		QaRobot.impliwait(30);
		QaRobot.ClickOnElement("expenlogin");
		QaRobot.PassValue("loginemailexp", Emailid);
		QaRobot.PassValue("loginpasswordexp", Password);
		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("Clickonexplogin");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("DAManageExpenses");
		QaRobot.scrollPage(2000);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("DACreateExpenseReportes");
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		QaRobot.PassValue("TripName", TripName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Trip Name is </i></b>" + TripName);
		Thread.sleep(2000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divTripDestinationCity']/p"), Destination, Destination_Name,
				By.xpath("//input[@id='txtDestination']"));
		Thread.sleep(3000);
		String DateSelection[] = Start_Date.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = End_Date.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaBrowser.driver.findElement(By.xpath("//div[@id='div_form']/div/div[3]/div/div[3]/div/div/span")).click();
		Thread.sleep(2000);
		ExpenseManagementTripSheet.selectDateInCalendarRoundTripNew(expDate, month, year, expDate1, month1, year1);
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltriptype']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(TripType);

		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlcostcenter']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(CostCenter);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("PerDiemAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Per Diem Allowance</i></b>");

		QaRobot.ClickOnElement("AdvanceAllowance");
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Advance Amount</i></b>");

		WebElement DropDown2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemCurrency']"));
		Select s2 = new Select(DropDown2);
		s2.selectByVisibleText(PerDiemCurrency);

		QaRobot.PassValue("PerDiemAmmount", PerDiemAmmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Per Diem Ammount Is </i></b>" + PerDiemAmmount);

		WebElement DropDown3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlAdvanceCurrency']"));
		Select s3 = new Select(DropDown3);
		s3.selectByVisibleText(AdvanceCurrency);

		QaRobot.PassValue("AdvanceAmount", AdvanceAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Advance Amount Is </i></b>" + AdvanceAmount);
		Thread.sleep(2000);

		QaRobot.PassValue("Descriptionexp", Description);
		QaExtentReport.test.log(Status.INFO, "<b><i>Description Is </i></b>" + Description);
		Thread.sleep(2000);

		QaExtentReport.extentScreenshot("Expense sheet");
		Thread.sleep(2000);

		QaRobot.ClickOnElement("expenseSaveButton");
		Alert alt = QaBrowser.driver.switchTo().alert();
		alt.accept();

		QaBrowser.driver.switchTo().window(ParentWindow);

		if (AddType.equalsIgnoreCase("Expense")) {
			QaRobot.scrollPage(-2000);
			Thread.sleep(2000);
			AddExpense(TripName, Category, Merchant, ExpenseFromDate, ExpenseToDate, ExpenseCurrency, ExpenseAmount,
					GSTNumber, ModeOfPayment, ExpenceComment);
		} else if (AddType.equalsIgnoreCase("Conveyance")) {
			QaRobot.scrollPage(-2000);
			Thread.sleep(2000);
			AddConveyance(TripName, AddType, ModeOfPayment, ExpenceComment, ConveyanceType, Corigin, COrigin_Name,
					CDestination, CDestination_Name, ConveyanceFromDate, ConveyanceToDate);
		} else if (AddType.equalsIgnoreCase("Expense+Conveyance")) {
			QaRobot.scrollPage(-2000);
			Thread.sleep(2000);
			AddExpense(TripName, Category, Merchant, ExpenseFromDate, ExpenseToDate, ExpenseCurrency, ExpenseAmount,
					GSTNumber, ModeOfPayment, ExpenceComment);
			AddConveyance(TripName, AddType, ModeOfPayment, ExpenceComment, ConveyanceType, Corigin, COrigin_Name,
					CDestination, CDestination_Name, ConveyanceFromDate, ConveyanceToDate);
		}
		QaExtentReport.extentScreenshot("Expense Sheet");
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close(); 
	}

	public static void AddExpense(String TripName, String Category, String Merchant, String ExpenseFromDate,
			String ExpenseToDate, String ExpenseCurrency, String ExpenseAmount, String GSTNumber, String ModeOfPayment,
			String ExpenceComment) throws Exception {
//		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow1 : handles1) {
//			if (!childWindow1.equals(ParentWindow1))
//				QaBrowser.driver.switchTo().window(childWindow1);
//		}
		QaRobot.ClickOnElement("AddExpenseButton1");
		QaExtentReport.extentScreenshot("AddExpense1");

		WebElement DropDown4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlCategory']"));
		Select s4 = new Select(DropDown4);
		s4.selectByVisibleText(Category);

		QaRobot.PassValue("Merchant", Merchant);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Write Merchant</i></b>");

		String DateSelection[] = ExpenseFromDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ExpenseToDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaRobot.ClickOnElement("ExpenseDate");
		Thread.sleep(2000);
		ExpenseManagementTripSheet.selectDateInCalendarExpense(expDate, month, year, expDate1, month1, year1);
		WebElement DropDown5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseCurrency']"));
		Select s5 = new Select(DropDown5);
		s5.selectByVisibleText(ExpenseCurrency);

		QaRobot.PassValue("ExpenseAmount", ExpenseAmount);
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense Amount Is </i></b>" + ExpenseAmount);
		Thread.sleep(2000);
		WebElement DropDown6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlGSTNumber']"));
		Select s6 = new Select(DropDown6);
		s6.selectByVisibleText(GSTNumber);
		Thread.sleep(2000);
		WebElement DropDown7 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseMOP']"));
		Select s7 = new Select(DropDown7);
		s7.selectByVisibleText(ModeOfPayment);
		Thread.sleep(2000);
		QaRobot.PassValue("ExpenceComment", ExpenceComment);
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense Comment Is </i></b>" + ExpenceComment);
		QaExtentReport.extentScreenshot("Expense Details");
		Thread.sleep(2000);

		WebElement DropDown8 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlExpenseTrip']"));
		Select s8 = new Select(DropDown8);
		s8.selectByVisibleText(TripName);

		QaRobot.ClickOnElement("ExpenseAdd");
		Thread.sleep(2000);
		Alert alt4 = QaBrowser.driver.switchTo().alert();
		alt4.accept();
//		Alert alt1 = QaBrowser.driver.switchTo().alert();
//		alt1.accept();
//		QaBrowser.driver.switchTo().window(ParentWindow1);
	}

	public static void AddConveyance(String TripName, String AddType, String ModeOfPayment, String ExpenceComment,
			String ConveyanceType, String Corigin, String COrigin_Name, String CDestination, String CDestination_Name,
			String ConveyanceFromDate, String ConveyanceToDate) throws Exception {
		if (AddType.equalsIgnoreCase("Expense+Conveyance")) {
			QaRobot.ClickOnElement("AddExpenseButton");
			Thread.sleep(2000);
		}
//		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow1 : handles1) {
//			if (!childWindow1.equals(ParentWindow1))
//				QaBrowser.driver.switchTo().window(childWindow1);
//		}
		QaRobot.ClickOnElement("DAConveyanceAdd");
		Thread.sleep(2000);
		WebElement DropDown8 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemProduct']"));
		Select s8 = new Select(DropDown8);
		s8.selectByVisibleText(ConveyanceType);
		Thread.sleep(2000);
		TestBase.listofautosuggestion(By.xpath("/html/body/div[1]/div[1]"), Corigin, COrigin_Name,
				By.xpath("//input[@id='txtPerDiemOrigin']"));
		Thread.sleep(3000);
		TestBase.listofautosuggestion(By.xpath("/html/body/div[2]/div"), CDestination, CDestination_Name,
				By.xpath("//input[@id='txtPerDiemDestination']"));
		Thread.sleep(3000);
		String DateSelectionC[] = ConveyanceFromDate.split("-");
		String yearC = DateSelectionC[2];
		String monthC = DateSelectionC[1];
		String expDateC = DateSelectionC[0];
		String DateSelection1C[] = ConveyanceToDate.split("-");
		String year1C = DateSelection1C[2];
		String month1C = DateSelection1C[1];
		String expDate1C = DateSelection1C[0];
		QaRobot.ClickOnElement("ConveyanceDate");
		Thread.sleep(2000);
		ExpenseManagementTripSheet.selectDateInCalendarConveyance(expDateC, monthC, yearC, expDate1C, month1C, year1C);
		QaRobot.PassValue("EXActualDistance", "1500");
		WebElement DropDown9 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemMOP']"));
		Select s9 = new Select(DropDown9);
		s9.selectByVisibleText(ModeOfPayment);
		Thread.sleep(2000);
		QaRobot.PassValue("ConveyanceComment", ExpenceComment);
		QaExtentReport.test.log(Status.INFO, "<b><i>Expense Comment Is </i></b>" + ExpenceComment);
		WebElement DropDown10 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlPerDiemContractType']"));
		Select s10 = new Select(DropDown10);
		s10.selectByVisibleText(TripName);
		QaExtentReport.extentScreenshot("Expense Details");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ConveyanceAdd1");
		Thread.sleep(3000);
		Alert alt4 = QaBrowser.driver.switchTo().alert();
		alt4.accept();
//		QaBrowser.driver.switchTo().window(ParentWindow1);
	}
}
