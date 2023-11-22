package features;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCases {
    WebDriver driver;
    @Before
    public void startDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "/home/karabo/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver(options);
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @After
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void gettingStarted(){
        String title = driver.getTitle();
        Assert.assertEquals("OpenCart", title);

    }
}
