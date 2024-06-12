package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class QaExtentReport {
	public static ExtentReports report;
	public static ExtentTest test;

	public static void test_htmlreport() throws IOException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MMM-yy & HH-mm-ss");
		String NewDate = d.format(date);

		report = new ExtentReports();

		File file = new File("C:\\Users\\Shubham.Natkar\\git\\Travog\\Reports\\" + NewDate + " report" + ".html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		ExtentSparkReporterConfig config = sparkreporter.config();
		config.setTheme(Theme.STANDARD);
		config.setReportName("Extent Report");
		config.setDocumentTitle("SBT");

		report.attachReporter(sparkreporter);
//		report
//		.createTest("Pre Approval Queue for Business Trip")
//		.assignAuthor("Shubham Natkar")
//		.assignDevice("Chrome");		
	}

	public static void extentScreenshot(String txt) throws IOException {
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(txt), txt).build());
	}

	public static void extentScreenshot1(String txt, String txt1) throws IOException {
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(txt), txt1).build());
//		String path = captureScreenshot(txt);
//		test.addScreenCaptureFromPath(path, txt1);
	}

	public static String captureScreenshot(String text) throws IOException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yy & HH-mm-ss");
		String NewDate = d.format(date);

		TakesScreenshot ts = (TakesScreenshot) QaBrowser.driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\Shubham.Natkar\\git\\Travog\\Screenshot\\" + NewDate + " " + text + ".jpg");
		FileUtils.copyFile(Source, Dest);
		return Dest.getAbsolutePath();
	}
}
