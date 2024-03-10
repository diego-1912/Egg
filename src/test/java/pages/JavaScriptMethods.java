package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptMethods {
    private WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        js = (JavascriptExecutor) driver;

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaScriptExecution() throws Exception {

        // driver.get(baseUrl);
        js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");

        // WebElement textBox = driver.findElement(By.id("name"));
        WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
        Thread.sleep(3000);
        // Finding element

        textBox.sendKeys("test");
        // Size of window
        long height = (Long) js.executeScript("return window.innerHeight;");
        long width = (Long) js.executeScript("return window.innerWidth;");

        System.out.println("Height is: " + height);
        System.out.println("Width is: " + width);

        // Scroll Down
        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);

        // Scroll Up
        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);

        // Scroll Element Into View
        WebElement element = driver.findElement(By.id("mousehover"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -190);");

        // Scroll Down to the bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //Click the Web Element
        WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
        js.executeScript("arguments[0].click();", checkBoxElement);

    }


    @After
    public void tearDown() throws Exception {
    }
}
