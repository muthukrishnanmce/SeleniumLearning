package LearnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumXpathLearning {

    /*

1. Launch URL "https://www.myntra.com/"
2. Maximize the browser
3. Search 'Shirt' in the Search bar [find it using Xpath]
4. Search for U.S Polo under brand
5. Check U.S Polo Assn under brand
6. Sort by 'what's new'
7. Get all the prices of the shirts available and store it in a List
8. Print all the prices of the Shirts

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
    public void excercise1() {
       WebDriver driver = initializeDriver();
       driver.get("https://www.myntra.com/");
       driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("shirt");
       driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys(Keys.ENTER);
       driver.findElement(By.xpath("//span[text()='Brand']/following-sibling::div[@class='filter-search-filterSearchBox']")).click();
       driver.findElement(By.xpath("//input[@class='filter-search-inputBox']")).sendKeys("U.S. Polo");
       driver.findElement(By.xpath("//input[@type='checkbox' and @value='U.S. Polo Assn.']/following-sibling::div")).click();
       driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
       driver.findElement(By.xpath("//ul[@class='sort-list']/li/label/input[@value='new']/..")).click();

       List<WebElement> resultShirts = driver.findElements(By.xpath("//ul[@class='results-base']/li/a/div/div[@class='product-price']"));

       ArrayList<String> shirtprice = new ArrayList<>();

       for(WebElement shirt:resultShirts) {
           shirtprice.add(shirt.getText());

       }

       for(String price:shirtprice){
           System.out.println(price);
       }


    }


    /*

    [9:57] Vidyabharathi R
classroom:1
========
1. Launch URL "https://www.myntra.com/"
2. Maximize the browser
3. Search 'Shirt' in the Search bar [find it using Xpath]
4. Search for U.S Polo under brand
5. Check U.S Polo Assn under brand
6. Sort by 'what's new'
7. Get all the prices of the shirts available and store it in a List
8. Print all the prices of the Shirtsclassroom:2
==========
1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All
4. Click Service Console from App Launcher
5. Select New Contact from the Contacts dropdown
6. Select Salutation
7.Enter Firstname
8. Enter Lastname
9. Enter the phone number
10. Click search on Account number
11. Enter the Account number
12. Select the Rating
13. Click on Save
14. Verify the toaster message
15.Enter the phone number
16.Click on Save
17.Verify the Toaster message
Login | Salesforce
Salesforce Customer Secure Login Page. Login to your Salesforce Customer Account.


https://login.salesforce.com/
Username:- ramkumar.ramaiah@testleaf.com
Password@123
Login | Salesforce
Salesforce Customer Secure Login Page. Login to your Salesforce Customer Account.




     */
    @Test
    public void salesforceTest() {
        WebDriver driver = initializeDriver();
        driver.get("https://login.salesforce.com");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

        driver.findElement(By.xpath("//button[@data-aura-class='forceHeaderButton salesforceIdentityAppLauncherHeader']")).click();
        driver.findElement(By.xpath("//button[@class='slds-button']")).click();
        driver.findElement(By.xpath("//p[text()='Service Console']")).click();

        driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
        driver.findElement(By.xpath("//a[@data-itemid='Contact']")).click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropDownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='oneActionsRibbon forceActionsContainer']")));
        dropDownMenu.click();
//        driver.findElement(By.xpath("//ul[@class='oneActionsRibbon forceActionsContainer']")).click();

        WebElement clickNew = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='New']")));
        clickNew.click();

//        driver.findElement(By.xpath("//a[@title='New']")).click();

//        driver.findElement(By.xpath("//button[@id='combobox-button-300']")).click();

        driver.findElement(By.xpath("//input[@class='slds-input' and @name='firstName']")).sendKeys("Test1");
        driver.findElement(By.xpath("//input[@class='slds-input' and @name='lastName']")).sendKeys("Test1LastName");
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();



    }

}
