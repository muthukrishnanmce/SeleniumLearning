package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void explicitWaitTest() {
        driver.get("http://www.leafground.com/pages/Alert.html");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();


    }

    @Test
    public void snapDealTest() {
        driver.get("https://www.snapdeal.com/");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement alertBtn = driver.findElement(By.id("pushAllow"));
        WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
        wait.until(ExpectedConditions.invisibilityOf(alertBtn));
        mensFashion.click();
    }


}
