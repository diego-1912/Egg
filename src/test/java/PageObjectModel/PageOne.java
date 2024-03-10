package PageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageOne {
    public static WebElement element = null;
//static, "This is for everyone, not just one thing."
    //null: starts without value


    ///////////////////////////Elements///////////////////////////////////
    public static WebElement destinationTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-destination"));
        return element;
    }

    public static WebElement originTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-origin"));
        return element;
    }

    public static WebElement departureDateTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-departing"));
        return element;
    }

    public static WebElement returnDateTextBox(WebDriver driver) {
        element = driver.findElement(By.id("flight-returning"));
        return element;
    }

    public static WebElement searchButton(WebDriver driver) {
        element = driver.findElement(By.id("search-button"));
        return element;
    }

///////////////////////////Methods///////////////////////////////////
    public static void clickOnSearchButton(WebDriver driver) {
        element = searchButton(driver);
        element.click();
    }

    public static void navigateToFlightsTab(WebDriver driver) {
        driver.findElement(By.id("header-history")).click();
        element = driver.findElement(By.id("tab-flight-tab"));
        element.click();
    }

    public static void fillOriginTextBox(WebDriver driver, String origin) {
        element = originTextBox(driver);
        element.sendKeys(origin);
    }

}
