package LearnSelenium.Week1Assessment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SalesForceExcercises {

    /*
    Salesforce Application
=================
TC001: Party Consent-Create
****************************
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Party Consent from App Launcher
4. Click on the Dropdown icon in the Party Consent tab
5. Click on New Party Consent
6. Enter Name as 'Salesforce Automation by *Your Name*'
7.Select the Individuals from the 'Party' field -
8.Create New Individual
9.Enter first and last name
10. Click save and verify the toaster message
11.Select Business Brand
12.Create new Business Brand
13.Enter the Name
14.Enter Orgid
15.Click save and verify the Toaster message
16.Click the consent captured contact point type as Email
17.Click save and verify Party Consent Name"

https://login.salesforce.com/
ramkumar.ramaiah@testleaf.com
Password@123
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
    public void TC001() {
        WebDriver driver = initializeDriver();
        driver.get("https://login.salesforce.com");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

        driver.findElement(By.xpath("//button[@data-aura-class='forceHeaderButton salesforceIdentityAppLauncherHeader']")).click();
        driver.findElement(By.xpath("//button[@class='slds-button']")).click();
        driver.findElement(By.xpath("//p[text()='Party Consent']")).click();
        driver.findElement(By.xpath("//a[@title='New']")).click();

        driver.findElement(By.xpath("//input[@id='2287:0']")).sendKeys("Salesforce Automation by Muthu");
        driver.findElement(By.xpath("//input[@id='2342:0']")).click();
        driver.findElement(By.xpath("//div[@id='2366:0']")).click();
        driver.findElement(By.xpath("//span[text()='First Name']/../following-sibling::input")).sendKeys("Muthukrishnan");
        driver.findElement(By.xpath("//span[text()='First Name']/../following-sibling::input")).sendKeys("Pandian");
        driver.findElement(By.xpath("//div[@class='modal-footer slds-modal__footer']/div/button[@title='Save']")).click();






    }


}
