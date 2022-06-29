package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Assesment3 {

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
    public void exercise1(){

        driver.get("https://login.salesforce.com");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

        driver.findElement(By.xpath("//a[contains(@class,'globalCreateTrigger')]//*[name()='svg']")).click();
        driver.findElement(By.xpath("//span[text()='New Task']")).click();

        driver.findElement(By.xpath("//label[text()='Subject']/..//input")).sendKeys("Bootcamp");
        driver.findElement(By.xpath("//span[text()='Name']/../following-sibling::div//input")).click();
        driver.findElement(By.xpath("//div[@class='listContent']/ul/li[1]")).click();
        driver.findElement(By.xpath("//span[text()='Status']/../following-sibling::div//a")).click();
        driver.findElement(By.xpath("//div[@class='select-options']/ul/li/a[@title='Waiting on someone else']")).click();
        driver.findElement(By.xpath("//div[@class='slds-grid bottomBar']//span[text()='Save']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Task']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//span[text()='Task']")).getText());



    }

    @Test
    public void exercise2(){
        driver.get("https://login.salesforce.com");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

        Actions build = new Actions(driver);
        WebElement toggle = driver.findElement(By.xpath("//span[text()='App Launcher']/.."));
        build.click(toggle);
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Content']/..")).click();

        driver.findElement(By.xpath("//span[text()=\"Today’s Tasks\"]/ancestor::article//span[text()='View All']")).click();


    }

}
