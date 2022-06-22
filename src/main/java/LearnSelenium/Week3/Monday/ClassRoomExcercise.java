package LearnSelenium.Week3.Monday;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassRoomExcercise {

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
    public void test1() {
        driver.get("https://www.nykaa.com/");
        WebElement brandLink = driver.findElement(By.xpath("//a[text()='brands']"));
        Actions action = new Actions(driver);
        action.moveToElement(brandLink).perform();
        driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
        driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]")).click();
        Assert.assertTrue(driver.getTitle().contains("L'Oreal Paris"));

        driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
        driver.findElement(By.xpath("//span[text()='Hair']")).click();
        driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'checkbox_Shampoo')]/div/following-sibling::div")).click();
        driver.findElement(By.xpath("//span[text()='Concern']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'Color Protection')]/div/following-sibling::div")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='filter-value' and text()='Shampoo']")).isDisplayed());

        driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();

//        ArrayList<String> windows = (ArrayList<String>)driver.getWindowHandles();

        Set<String> windowsSet = driver.getWindowHandles();

        ArrayList<String> windows = new ArrayList<>(windowsSet);
        driver.switchTo().window(windows.get(1));
        System.out.println(driver.getTitle());

        Select sizes =  new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));
        sizes.selectByIndex(2);
        String mrpPrice = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
        Assert.assertTrue(mrpPrice.equals("₹299"));
        driver.findElement(By.xpath("(//span[text()='Add to Bag']/..)[1]")).click();
        driver.findElement(By.xpath("//span[@class='cart-count']")).click();

        //move the control to iframe
        WebElement checkoutFrame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
        driver.switchTo().frame(checkoutFrame);

        String grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div")).getText();
        driver.findElement(By.xpath("//span[text()='Proceed']/../..")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE AS GUEST')]")).click();
        String grandTotlaAtCheckout = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div")).getText();
        System.out.println("GrandTotal at Bag:" + grandTotal+ ": GrandTotal at checkout:"+grandTotlaAtCheckout);



    }


}
