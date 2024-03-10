package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestClass {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        String baseURL = "https://www.wikipedia.org/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get(baseURL);
        driver.findElement(By.linkText("Privacy Policy")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.findElement(By.linkText("Policies and guidelines")).click();

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        //actions.scrollByAmount(0, 1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");

        driver.findElement(By.xpath("//*[text()='Create account']")).click();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");


    }


    }





