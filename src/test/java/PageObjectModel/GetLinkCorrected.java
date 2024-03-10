package PageObjectModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetLinkCorrected {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://es.wikipedia.org/wiki/La_Gioconda";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFindLinks() {
        driver.get(baseUrl);

        // Find all the links on the web page
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));

        // Create a list to store the URLs of the links
        List<String> links = new ArrayList<>();

        // Iterate through each link element and get the href attribute
        for (WebElement element : linkElements) {
            String url = element.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                boolean isEnable = element.isEnabled();
                String answer = String.valueOf(isEnable);
                links.add(url + " the link is enable?   " + answer);


            }
        }
        // Print the URLs of all the links
        for (String link : links) {

            System.out.println(link);
        }
        System.out.println("the number of links is: " + links.size());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
