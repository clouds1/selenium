import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumWithProxy {

    public static void main(String[] args) {
        // Set proxy details
        String proxyServer = "http://your.proxy.server:your-proxy-port";
        String proxyUsername = "your-username";
        String proxyPassword = "your-password";

        // Set browser capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANY);

        // Set proxy settings
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyServer);
        proxy.setFtpProxy(proxyServer);
        proxy.setSslProxy(proxyServer);
        proxy.setProxyType(Proxy.ProxyType.MANUAL);

        // Set proxy credentials
        String proxyCredentials = String.format("%s:%s", proxyUsername, proxyPassword);
        proxy.setSocksUsername(proxyUsername);
        proxy.setSocksPassword(proxyPassword);
        proxy.setHttpProxy(proxyCredentials);
        proxy.setFtpProxy(proxyCredentials);
        proxy.setSslProxy(proxyCredentials);

        //capabilities.setCapability(CapabilityType.PROXY, proxy);

        // Set Selenium Hub URL
        URL hubUrl = null;
        try {
            hubUrl = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Create WebDriver instance
        WebDriver driver = new RemoteWebDriver(hubUrl, capabilities);

        // Navigate to Bing
        driver.get("http://www.bing.com");

        // Perform some actions (e.g., search)
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium with Proxy");
        searchBox.submit();

        // Wait for a while to see the results
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
