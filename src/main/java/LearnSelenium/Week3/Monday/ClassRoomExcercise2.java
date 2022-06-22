package LearnSelenium.Week3.Monday;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;

public class ClassRoomExcercise2 {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() {

        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.findElement(By.id("username")).sendKeys("DemosalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();

        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
        driver.findElement(By.xpath("//span[text()='From Contact']/../following-sibling::td/a")).click();



//        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windows.get(1));
        switchToWindow(driver,1);
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
        switchToWindow(driver,0);

        driver.findElement(By.xpath("//span[text()='To Contact']/../following-sibling::td/a")).click();
        switchToWindow(driver,1);
        driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();
        switchToWindow(driver,0);
        driver.findElement(By.xpath("//a[text()='Merge']")).click();

        driver.switchTo().alert().accept();
//        driver.switchTo().defaultContent();
//
//        System.out.println(driver.getTitle());


    }

    public void switchToWindow(WebDriver driver, int index) {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
    }
}
