package expenseTravog;

import java.util.Set;

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
public class CamSbtExpenseBudgetManagement {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CamSbtExpenseManagement", "BudgetManagemnet");
	}

	@Test(dataProvider = "getexceldata")
	public static void Profiling1(String TestCaseId, String TestScenario, String Source, String URL, String Emailid,
			String Password, String BugetAmount, String BudgetPer, String BudApplicableOn,
			String BudApplicableSearchType, String BudTypeSelect, String BudTypeName) throws Exception {
		QaExtentReport.test = QaExtentReport.report.createTest("Test on CAM SBT expense Budget Management");
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);
		QaRobot.ClickOnElement("expenlogin");
		QaRobot.PassValue("loginemailexp", Emailid);
		QaRobot.PassValue("loginpasswordexp", Password);
		QaExtentReport.extentScreenshot("Login Page");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("Clickonexplogin");
		Thread.sleep(3000);
		QaRobot.mouseHover("//span[@id='HeaderTop_lblSettingMenu']", "//span[@id='HeaderTop_lblComapnayManagement']");
		QaExtentReport.extentScreenshot("Corporate Management");
		QaRobot.ClickOnElement("BudgetManagemnet");
		QaExtentReport.extentScreenshot("BudgetManagemnet");
		QaRobot.ClickOnElement("BudAddNew");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add New Button</i></b>");
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		QaRobot.PassValue("BugetAmount", BugetAmount);
		WebElement DropDown = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlContractType']"));
		Select s = new Select(DropDown);
		s.selectByVisibleText(BudgetPer);
		Thread.sleep(2000);
		WebElement DropDown1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlApplicableOn']"));
		Select s1 = new Select(DropDown1);
		s1.selectByVisibleText(BudApplicableOn);
		Thread.sleep(3000);
		budApplicableSearchType(BudApplicableSearchType, BudTypeSelect, BudTypeName);
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Add Budget expense");
		QaRobot.ClickOnElement("BudgetManagemnetSave");
		QaExtentReport.extentScreenshot(" Saved Budget successfully");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Budget Managemnet Save Button</i></b>");
	}

	@AfterMethod
	public static void afterMetod() {
		QaExtentReport.test.getExtent().flush();
//		QaBrowser.driver.close();
	}

	public static void budApplicableSearchType(String BudApplicableSearchType, String BudTypeSelect, String BudTypeName)
			throws Exception {
		if (BudApplicableSearchType.equalsIgnoreCase("SelectAllType")) {
			QaRobot.ClickOnElement("SelectAllType");
			Thread.sleep(3000);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select All Applicable Type</i></b>");
		} else if (BudApplicableSearchType.equalsIgnoreCase("SearchType")) {
			int tS = Integer.parseInt(BudTypeSelect);
			for (int i = 1; i <= tS; i++) {
				String[] tN = BudTypeName.split(",");
				String b = tN[i - 1];
				TestBase.listofautosuggestion2(By.xpath("(//div[@class='checkbox pt0'])[2]/table/tbody/tr/td"), b,
						By.xpath("//input[@id='txtSearch']"));
			}
		}
	}
}
