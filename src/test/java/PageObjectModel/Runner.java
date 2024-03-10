package PageObjectModel;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Runner{
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        PageOne.fillOriginTextBox(driver, "New York");
        PageOne.destinationTextBox(driver).sendKeys("Chicago");
        PageOne.departureDateTextBox(driver).sendKeys("12/25/2014");
        // Added a line to clear the return date text box
        // before entering the return date, because Expedia by default
        // enters the return date same as the departure date
        PageOne.returnDateTextBox(driver).clear();
        PageOne.returnDateTextBox(driver).sendKeys("12/31/2014");
        PageOne.clickOnSearchButton(driver);
    }

    @After
    public void tearDown() throws Exception {
    }

}