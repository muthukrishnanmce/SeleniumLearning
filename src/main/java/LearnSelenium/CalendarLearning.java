package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CalendarLearning {

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
    public void redBusTest() {

        String DateToSelect = "28-08-2022";

        String eDate = DateToSelect.split("-")[0];
        String eMonth = DateToSelect.split("-")[1];
        String eYear = DateToSelect.split("-")[2];

        Month monthToSelect = Month.of(Integer.parseInt(eMonth));
        Month monthCurrent = Month.of(LocalDate.now().getMonth().getValue());
        System.out.println(monthCurrent);

        driver.get("https://www.redbus.in/");
        driver.findElement(By.id("onward_cal")).click();
        String currentDisplayedMonth = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText().substring(0,3).trim();
        System.out.println(currentDisplayedMonth);
        System.out.println(monthToSelect);


//        System.out.println(monthCurrent);


    }

}
