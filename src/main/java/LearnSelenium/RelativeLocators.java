package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;

public class RelativeLocators {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void relativeLocatorTest() {

        driver.get("http://leaftaps.com/opentaps/control/main");
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("userName");
        WebElement passwordInput = driver.findElement(with(By.tagName("input")).below(usernameInput));
        passwordInput.sendKeys("test");


    }


}
