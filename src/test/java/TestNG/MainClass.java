package TestNG;

import com.aventstack.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {

    WebDriver driver;
    String baseURL;
    ExtentReports extent;
    @BeforeClass
    @Parameters({"browser"})


    public void setUp(String browser) {

        baseURL = "https://www.facebook.com";
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void testLogin() throws InterruptedException, IOException {


        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("pass")).sendKeys("test");
        driver.findElement(By.id("Loginbutton")).click();


    }

    @AfterMethod
    public void cleanUp(ITestResult testResult) throws IOException {



        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed: " + testResult.getMethod().getMethodName());
            String filename = getRandomString(10) + ".png";
            String directory = System.getProperty("user.dir") + "//screenshots//";
            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + filename));
        }
        driver.quit();
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int)(Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}