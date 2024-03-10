package pages;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


    public class DinamicDropdown {
        private WebDriver driver;
        private String baseUrl;



        public void setUp() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //"MicrosoftEdge" "chrome" "firefox"
            capabilities.setBrowserName("chrome"); // Set the browser name

            // Set the platform to WINDOWS (assuming you are running the grid on Windows)
            capabilities.setPlatform(Platform.WINDOWS);

            // Set the URL of the Selenium Grid Hub running on your local machine
            URL hubUrl = new URL("http://localhost:4444/wd/hub");

            // Create a new instance of the RemoteWebDriver
            driver = new RemoteWebDriver(hubUrl, capabilities);

            baseUrl = "https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal";
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseUrl);
        }

     @Test
        public void testAutocomplete() throws Exception {
            String partialText = "louvre";
            String textToSelect = "Louvre Abou Dabi";

            WebElement textField = driver.findElement(By.xpath("//input[@placeholder='Rechercher sur Wikipédia']"));
            textField.sendKeys(partialText);

            WebElement ulElement = driver.findElement(By.id("cdx-typeahead-search-menu-0"));

            String innerHTML = ulElement.getAttribute("innerHTML");
            System.out.println(innerHTML);

            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            Thread.sleep(3000);

            for (WebElement element : liElements) {
                System.out.println(element.getText());
                if (element.getText().contains(textToSelect)) {
                    System.out.println("Selected: " + element.getText());
                    element.click();

                    break;
                }
                // Take a screenshot and save it to a file
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                try {
                    // Specify the path where you want to save the screenshot
                    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\DiegoVargas\\IdeaProjects\\SeleniumJavaFinal\\src\\test\\Resources\\features\\Screenshots.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        @Test
        public void testAutocomplete2() throws Exception {
            String partialText = "louvre";
            String textToSelect = "Louvre Abou Dabi";

            WebElement textField = driver.findElement(By.xpath("//input[@placeholder='Rechercher sur Wikipédia']"));
            textField.sendKeys(partialText);

            WebElement ulElement = driver.findElement(By.id("cdx-typeahead-search-menu-0"));

            String innerHTML = ulElement.getAttribute("innerHTML");
            System.out.println(innerHTML);

            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            Thread.sleep(3000);

            for (WebElement element : liElements) {
                System.out.println(element.getText());
                if (element.getText().contains(textToSelect)) {
                    System.out.println("Selected: " + element.getText());
                    element.click();

                    break;
                }
                // Take a screenshot and save it to a file
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                try {
                    // Specify the path where you want to save the screenshot
                    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\DiegoVargas\\IdeaProjects\\SeleniumJavaFinal\\src\\test\\Resources\\features\\Screenshots.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        @Test
        public void testAutocomplete4 () throws Exception {
            String partialText = "louvre";
            String textToSelect = "Louvre Abou Dabi";

            WebElement textField = driver.findElement(By.xpath("//input[@placeholder='Rechercher sur Wikipédia']"));
            textField.sendKeys(partialText);

            WebElement ulElement = driver.findElement(By.id("cdx-typeahead-search-menu-0"));

            String innerHTML = ulElement.getAttribute("innerHTML");
            System.out.println(innerHTML);

            List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
            Thread.sleep(3000);

            for (WebElement element : liElements) {
                System.out.println(element.getText());
                if (element.getText().contains(textToSelect)) {
                    System.out.println("Selected: " + element.getText());
                    element.click();

                    break;
                }
                // Take a screenshot and save it to a file
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                try {
                    // Specify the path where you want to save the screenshot
                    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\DiegoVargas\\IdeaProjects\\SeleniumJavaFinal\\src\\test\\Resources\\features\\Screenshots.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        @AfterMethod


        public void tearDown() throws Exception {
            driver.quit();
        }
    }

