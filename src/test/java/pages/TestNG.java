package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNG {
    WebDriver driver;
    String baseURL;


    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        baseURL = "https://www.chateauversailles.fr/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testNamesearchForMarieAntoinette() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tarteaucitronPersonalize2']")).click();
        driver.findElement(By.xpath("//button[@id='open-form']//i[@class='icon-loop']")).click();
        driver.findElement(By.xpath("//input[@id='search-block-form-header-input']")).sendKeys("Marie Antoinette");
        driver.findElement(By.xpath("//form[@id='search-block-form-header']//i[@class='icon-loop']")).click();

        String title = driver.getTitle();
        System.out.println("title of the page is " + title);
        String url = driver.getCurrentUrl();
        System.out.println("current URL is :"+ url);
        String navigateToUrl = "https://don.chateauversailles.fr/remeublement-part/~mon-don#form-error";
        driver.navigate().to(navigateToUrl);

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement prepare = driver.findElement(By.xpath("//li[@class=\"expanded menu-mlid-907 pr-parer-ma-visite mid-907\"]/a"));
        System.out.println("Is enable" +  prepare.isEnabled());

        List<WebElement> options = driver.findElements(By.id("//ul[@id='select2-country-results']//child::*[contains(@class, 'flag')]"));
        System.out.println("options are " + options);
        int optionnumber= options.size();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }


    }



