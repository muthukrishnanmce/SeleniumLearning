package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FramesLearning {

    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

    @Test
    public void testFrames() {
        WebDriver driver = initializeDriver();
        driver.get("http://www.leafground.com/pages/frame.html");


        driver.switchTo().frame("wrapframe");
        driver.findElement(By.id("Click")).click();
        System.out.println(driver.findElement(By.id("Click")).getText());

        driver.close();

    }


    @Test
    public void testServiceNow() throws InterruptedException {

        WebDriver driver = initializeDriver();
        driver.get("https://dev79735.service-now.com/navpage.do");

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("MuagE2bCJ%!3");
        driver.findElement(By.id("sysverb_login")).click();

        Thread.sleep(10000);

        Shadow shadow = new Shadow(driver);
        shadow.findElementByXPath("//div[@id='all']").click();
        shadow.findElementByXPath("//span[text()='Incidents']").click();
        Thread.sleep(10000);
        driver.switchTo().frame("gsft_main");

        shadow.findElementByXPath("//button[text()='New']").click();
        String INCNumber = shadow.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
        shadow.findElementByXPath("//input[@id='incident.short_description']").sendKeys("This is a test");
        shadow.findElementByXPath("//button[@id='sysverb_insert_bottom']").click();

        System.out.println(INCNumber);




    }

}
