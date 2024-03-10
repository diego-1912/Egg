package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//basepage
public class BasePageUsefulMethods {

    private WebDriver driver;
    private final WebDriverWait wait;

    public BasePageUsefulMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set the default wait time to 10 seconds
    }

    public WebElement findElementByXpath(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement findElement(String locator, String type) {
        type = type.toLowerCase();
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds

        switch (type) {
            case "id":
                System.out.println("Waiting for element with id: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
                break;
            case "name":
                System.out.println("Waiting for element with name: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
                break;
            case "xpath":
                System.out.println("Waiting for element with xpath: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                break;
            case "css":
                System.out.println("Waiting for element with css: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
                break;
            case "classname":
                System.out.println("Waiting for element with classname: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
                break;
            case "tagname":
                System.out.println("Waiting for element with tagname: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
                break;
            case "linktext":
                System.out.println("Waiting for element with link text: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
                break;
            case "partiallinktext":
                System.out.println("Waiting for element with partial link text: " + locator);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
                break;
            default:
                System.out.println("Locator type not supported");
        }
        return element;
    }

    public List<WebElement> getElementList(String locator, String type) {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<>();
        switch (type) {
            case "id":
                elementList = driver.findElements(By.id(locator));
                break;
            case "name":
                elementList = driver.findElements(By.name(locator));
                break;
            case "xpath":
                elementList = driver.findElements(By.xpath(locator));
                break;
            case "css":
                elementList = driver.findElements(By.cssSelector(locator));
                break;
            case "classname":
                elementList = driver.findElements(By.className(locator));
                break;
            case "tagname":
                elementList = driver.findElements(By.tagName(locator));
                break;
            case "linktext":
                elementList = driver.findElements(By.linkText(locator));
                break;
            case "partiallinktext":
                elementList = driver.findElements(By.partialLinkText(locator));
                break;
            default:
                System.out.println("Locator type not supported");
        }
        if (elementList.isEmpty()) {
            System.out.println("Element not found with " + type + ": " + locator);
        } else {
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementList;
    }

    public boolean isElementPresent(String locator, String type) {
        List<WebElement> elementList = getElementList(locator, type);
        return !elementList.isEmpty();
    }
}
