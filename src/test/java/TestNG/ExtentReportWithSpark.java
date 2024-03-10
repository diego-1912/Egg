package TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

public class ExtentReportWithSpark  extends TestListenerAdapter {

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;
    public static void startExtentReports() {

        ExtentReports extentReports = new ExtentReports();
 File file = new File("report.html");
        ExtentSparkReporter extentSpark = new ExtentSparkReporter (file); extentReports.attachReporter (extentSpark);

    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }

}
