package LearnSelenium.Week1Assessment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class RedBusExcercise {

    /*
    Redbus application
===============
Launch the url https://www.redbus.in/
Enter From -Madiwala Bangalore
Enter To Koyambedu Chennai
Select the Date 10-Jun-2022 08-Jun-2022
Click Search buses
Click After 6pm under Departure time
Click Sleeper under Bus types
Select the Primo
Get the number of buses found
Get the Bus fare and sort them in ascending order
Close the application
     */


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
    public void redBusTest() {
        WebDriver driver = initializeDriver();
        driver.get("https://www.redbus.in/");

        driver.findElement(By.id("src")).sendKeys("Madiwala Bangalore");
        driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[@select-id='results[0]']")).click();
        driver.findElement(By.id("dest")).sendKeys("Koyambedu, Chennai");
        driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[@select-id='results[0]']")).click();
        driver.findElement(By.id("onward_cal")).click();
        driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[text()='10']")).click();
        driver.findElement(By.id("search_btn")).click();
        driver.findElement(By.xpath("//label[@for='dtAfter 6 pm' and @title='After 6 pm']")).click();
        driver.findElement(By.xpath("//label[@for='bt_SLEEPER' and @title='SLEEPER']")).click();
        driver.findElement(By.xpath("//li[@class='bannerTiles fl'][1]")).click();
//        driver.findElement(By.xpath("//div[@class='open-primo']")).click();
        String numofBus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
        driver.findElement(By.xpath("//a[text()='Fare']")).click();

        System.out.println(numofBus);

        List<WebElement> priceFareList = driver.findElements(By.xpath("//div[@class='seat-fare ']/div/following-sibling::div/span"));

        for(WebElement indFare:priceFareList) {
            System.out.println(indFare.getText());

        }



        driver.close();




    }

}
