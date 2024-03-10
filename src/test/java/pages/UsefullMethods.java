package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UsefullMethods {

    WebDriver driver;
    String baseURL;


    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        baseURL = "https://don.chateauversailles.fr/remeublement-part/~mon-don#form-error";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testNamesearchForMarieAntoinette() throws InterruptedException {

        /////////////////////////Get Text
        driver.get(baseURL);
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.id("type-b"));
        String nameOfTheElement= option.getText();
        System.out.println("the name of this is" + nameOfTheElement);

///////////////////////////////// get Atrribute

        WebElement element = driver.findElement(By.id("type-b"));
        String elementValue = element.getAttribute("class");
        System.out.println("the value is =" + elementValue);

        WebElement element2 = driver.findElement(By.id("type-b"));
        boolean elementpresence =  element.isDisplayed();


        }


}

