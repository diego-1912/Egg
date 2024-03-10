package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {


    public static Actions actions;
    protected static WebDriver driver; // Variable shared across all instances of the class
    protected WebDriverWait wait; // Non-static variable named wait of type WebDriverWait

    static {
        // Initializes the driver variable
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        // Initialize the wait variable in the constructor
        wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(50000));
    }


    // Navigate to the specified URL
    // Use the parameter URL, not the string "url"
    public void navigateTo(String URL) {
        driver.get(URL);
    }

    //

    // find element + the time)
    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Find, waiting time(locator) + click, we define the time for all methods
    //find +  time + click
    public void clickElement(String locator) {
        find(locator).click();
    }



    //verify element is present
    public void checkifElementIsPresent(String locator) {
        find(locator).isDisplayed();
    }

    //Find element and click (with link text)

    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
    // Method for writing text to an input field
    public void write(String locator, String textToWrite) {
        WebElement element = find(locator);
        element.clear(); // Clean the input field first
        element.sendKeys(textToWrite);
    }

    // Dropdown
    // 1. Select the option by value
    public void selectFromDropdownByValue(String locator, String value) {
        WebElement dropdownElement = find(locator);
        dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    // Close the browser
    public static void closeBrowser() {
        driver.quit();
    }


    // 2. Select from the index (order)
    public void selectFromDropdownByIndex(String locator, int index) {
        WebElement dropdownElement = find(locator);
        dropdownElement.click();
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    // Get the number of options in a dropdown
    public int getDropdownOptionsCounts(String locator) {
        Select dropdown = new Select(find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public void printDropdownOptions(String locator) {
        List<String> values = getDropdownOptionsList(locator);
        for (String option : values) {
            System.out.println(option);
        }
    }

    ///////////////////////////////////////////////////////////////////// real dropdown

    public List<String> getDropdownOptionsList(String locator) {
        List<WebElement> dropdownOptionsList = driver.findElements(By.xpath(locator));
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptionsList) {
            values.add(option.getText());
        }
        System.out.println("Dropdown options: " + values); // Print the dropdown options
        return values;
    }

    ////////////////////////////////////////////////////////////////////Dropdw Option Count

    public int getDropdownOptionsCount(String locator) {
        List<WebElement> dropdownOptionsList = driver.findElements(By.xpath(locator));
        int count = dropdownOptionsList.size();
        System.out.println("Number of dropdown options: " + count); // Print the number of dropdown options
        return count;
    }
///////////////select dropdwon by Index

    //ACTIONS LIBRARY///

    public void hoverOverElement(String locator) {  //Find element without clicking
        actions.moveToElement(find(locator));
    }

    public void doubleClikc(String locator) {
        actions.doubleClick(find(locator));
    }

    public void rightClikc(String locator) {
        actions.contextClick(find(locator));
    }

//not recomended to use this method , assertion should be part of the Steps Definition
    //public void validateText(String locator, String textToValidate){
    //   Assert.assertEquals(textToValidate, find(locator).getText());
    // }

    //Get the text of a web element

    public String getTextFromElement(String locator) {
        return find(locator).getText();
    }


    public boolean elementIsDisplayed(String locator) {
        return find(locator).isDisplayed();
    }

    // get a List of web elements (not strings

    public List<WebElement> bringMeAllTheElements(String locator) {
        return driver.findElements(By.className(locator));
}

    }



