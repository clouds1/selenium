import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chrome-win64");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANY);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    public void tearDown() {
        driver.quit();
    }

    public void blazedemo1() {
        driver.get("https://blazedemo.com/index.php");
        driver.manage().window().setSize(new Dimension(1078, 824));
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
        }
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'Rome']")).click();
        }
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.cssSelector(".control-group:nth-child(3) > .control-label")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("John");
        driver.findElement(By.id("address")).sendKeys("Smith");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Atown");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Btown");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("NA");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("20000");
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("101");
        driver.findElement(By.cssSelector(".control-group:nth-child(9)")).click();
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardMonth")).sendKeys("1");
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2024");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("John Smith");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".hero-unit")).click();
    }
}
