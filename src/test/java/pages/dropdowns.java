package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropdowns {

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

        driver.get(baseURL);
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.xpath("//Select[@name='country']"));

        driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);

        Select select = new Select(option);

        List<WebElement> options = select.getOptions();
        int size = options.size();

        for (int i=0; i<size; i++) {
            String optionName = options.get(i).getText();
            System.out.println(optionName);
            select.selectByIndex(i);



}}}






